package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.VendaDto;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
//	Futura implementação de incremento e decremento de estoque
//	@Autowired
//	private EstoqueService estoqueSer;
	
	@Autowired 
	private ProdutoService produtoSer;
	
	// Funções CRUD***
	public void createVenda(VendaDto cadastro) {
		
		Venda venda = new Venda();
		venda.setProdutos(produtoSer.findProdutos(cadastro.getProdutosId()));
		
		double valor = 0;
		for(int i=0; i < venda.getProdutos().size(); i++) {
			valor += venda.getProdutos().get(i).getValor() * cadastro.getProdutosQntd().get(i);
		}
		
		venda.setValor(valor);
		
		repository.save(venda);
		System.out.println("Criado");
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
	
	//Buscar vendas pelo Id
	public List<Venda> findVendas(List<Long> vendasId){
		return repository.findAllById(vendasId);
	}
}
