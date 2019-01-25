package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CadastroVenda;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	@Autowired
	private ProdutoService produtoService;

	// Funções CRUD***
	public void createVenda(CadastroVenda cadastro) {
		Venda venda = new Venda();
		venda.setProdutos(produtoService.findProdutos(cadastro.getProdutos()));
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
}
