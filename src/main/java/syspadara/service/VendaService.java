package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.estoque.EstoqueEditQntd;
import syspadara.dto.venda.VendaCadastro;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepo;

	@Autowired
	private ProdutoService produtoSer;

	@Autowired
	private EstoqueService estoqueSer;

	// Funções CRUD***
	public void createVenda(VendaCadastro cadastro) {
		Venda venda = new Venda();
		venda.setProdutos(produtoSer.findProdutos(cadastro.getProdutosId()));

//		int pdSize = cadastro.getProdutosId().size();
//		int qtSize = cadastro.getProdutosQntd().size();

		// Função para validar a venda do produto com base na quantidade vendida
		boolean vendaOk = true;
		Integer indice = 0;

		if (cadastro.getProdutosQntd().size() > cadastro.getProdutosId().size()) {
			// Ex: se hoiuver 2 produtos, mas existe 3 quantidades declaradas
			// a venda nãoé finalizada
			System.out.println(
					"Verifique se não está faltando nenhum produto\nOu se há uma quantidade declarada sem produto!");
			vendaOk = false;
		}

		// Lista de objetos que alterarão o estoque
		List<EstoqueEditQntd> editsEstoque = new ArrayList<>();

		try {
			// verifica se a venda está ok
			if (vendaOk) {
				for (Long produtoId : cadastro.getProdutosId()) {

					// Variaveis para simplificar a codificação
					Integer produtoEstoque = estoqueSer.findProdutoEstoque(produtoId);
					Integer qntdVendida = cadastro.getProdutosQntd().get(indice);

					// Verificação da quantidade vendida
					if (produtoEstoque >= qntdVendida && qntdVendida > 0) {

						// Variaveis para simplificar a codificação
						Long estoqueId = estoqueSer.findEstoqueId(produtoId);
						Integer novaQntd = estoqueSer.findProdutoEstoque(produtoId) - qntdVendida;

						// Objeto que altera o estoque de um produto a cada venda e adiciona o objeto
						// editVenda à uma lista de alterações
						EstoqueEditQntd editQntd = new EstoqueEditQntd();
						editQntd.setEstoqueId(estoqueId);
						editQntd.setProdutoQntd(novaQntd);
						editsEstoque.add(editQntd);

					} else {
						// Caso a quantidade vendida é maior que a quantidade no estoque,
						// a venda nao é finalizada
						System.out.println("Qntd vendida do produto: " + produtoSer.findProduto(produtoId).getNome()
								+ " é maior que o valor em estoque!");
						vendaOk = false;
						break;
					}
					indice++;
				}

				// Caso nao ocorra problemas com a venda a venda é salva e a atualização dos
				// estoque é feita
				if (vendaOk) {
					vendaRepo.save(venda);

					for (EstoqueEditQntd edit : editsEstoque) {
						estoqueSer.editQntd(edit);
						System.out.println(edit.getEstoqueId());
						System.out.println(edit.getProdutoQntd());
					}
					System.out.println("Criado venda");
				}

			} else {
				System.out.println("Venda Cancelada!");
			}

		} catch (IndexOutOfBoundsException indexException) {
			System.out.println("Aconteceu um erro: " + indexException.getMessage()
					+ "\nVerifique se não há produtos sem a quantidade!");
		}
	}

	public Venda readVenda(Long id) {
		return vendaRepo.findById(id).get();
	}

	public void updateVenda(Venda venda) {
		vendaRepo.save(venda);
		System.out.println("Atualizado");
	}

	public void deleteVenda(Long id) {
		Venda venda = vendaRepo.findById(id).get();
		vendaRepo.delete(venda);
		System.out.println("Deletado");
	}
	// *************

	public List<Venda> readAll() {
		return vendaRepo.findAll();
	}

	// Buscar vendas pelo Id
	public List<Venda> findVendas(List<Long> vendasId) {
		return vendaRepo.findAllById(vendasId);
	}

	// Buscar venda pelo Id
	public Venda findVenda(Long vendaId) {
		return vendaRepo.findById(vendaId).get();
	}
}
