package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.venda.VendaCadastro;
import syspadara.dto.estoque.EstoqueEditQntd;
import syspadara.model.Produto;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	@Autowired
	private ProdutoService produtoSer;
	
	@Autowired
	private EstoqueService estoqueSer;

	// Funções CRUD***
	public void createVenda(VendaCadastro cadastro) {
		Venda venda = new Venda();
		venda.setProdutos(produtoSer.findProdutos(cadastro.getProdutosId()));
		
		boolean ok = true;
		int index = 0;
		for(Produto produto: venda.getProdutos()) {
			if(estoqueSer.findProdutoEstoque(produto.getId()) < cadastro.getProdutosQntd().get(index) || cadastro.getProdutosQntd().get(index) == 0) {
				ok = false;
			}
			index++;
		}
		
		if(ok == false) {
			System.out.println("Venda não realizada! Verifique a quantidade vendida!");
		} else {
			index = 0;
			for(Produto produto: venda.getProdutos()) {
				
				//Calculo do novo estoque
				int novoEstoque = estoqueSer.findProdutoEstoque(produto.getId()) - cadastro.getProdutosQntd().get(index);
				EstoqueEditQntd editQntd = new EstoqueEditQntd(produto.getId(), novoEstoque);
				
				//Alteração do estoque na base de dados
				estoqueSer.editQntd(editQntd);
				index++;
			}
			
			//Salvar a venda caso nenhum produto tenha a quantidade maior que o saldo em estoque
			repository.save(venda);
			System.out.println("Criado");
		}
	}

	public Venda readVenda(Long id) {
		return repository.findById(id).get();
	}

	public void updateVenda(Venda venda) {
		repository.save(venda);
		System.out.println("Atualizado");
	}

	public void deleteVenda(Long id) {
		Venda venda = repository.findById(id).get();
		repository.delete(venda);
		System.out.println("Deletado");
	}
	// *************

	public List<Venda> readAll() {
		return repository.findAll();
	}

	// Buscar vendas pelo Id
	public List<Venda> findVendas(List<Long> vendasId) {
		return repository.findAllById(vendasId);
	}

	// Buscar venda pelo Id
	public Venda findVenda(Long vendaId) {
		return repository.findById(vendaId).get();
	}
}
