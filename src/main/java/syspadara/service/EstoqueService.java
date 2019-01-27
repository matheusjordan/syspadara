package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.estoque.EstoqueCadastro;
import syspadara.dto.estoque.EstoqueEditQntd;
import syspadara.model.Estoque;
import syspadara.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepo;

	@Autowired
	private ProdutoService produtoSer;
	
	// Funções CRUD***
	public void createEstoque(EstoqueCadastro cadastro) {
		
		// Dto utilizado possui um Long que será convertido em Produto,
		// após passar pelo metodo findProduto de ProdutoService
		Estoque estoque = new Estoque();
		estoque.setProduto(produtoSer.findProduto(cadastro.getProdutoId()));
		estoque.setProdutoQntd(cadastro.getQntd());
		estoqueRepo.save(estoque);
		System.out.println("Criado");
	}

	public Estoque readEstoque(Long id) {
		return estoqueRepo.findById(id).get();
	}

	public void updateEstoque(Estoque estoque) {
		estoqueRepo.save(estoque);
		System.out.println("Atualizado");
	}

	public void deleteEstoque(Long id) {
		estoqueRepo.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	public List<Estoque> findAll() {
		return estoqueRepo.findAll();
	}
	
	//Função para alterar a quantidade de um produto no estoque
	public void editQntd(EstoqueEditQntd editQntd) {
		Estoque estoque = estoqueRepo.findById(editQntd.getEstoqueId()).get();
		estoque.setProdutoQntd(editQntd.getProdutoQntd());
		estoqueRepo.save(estoque);
		System.out.println("Atualizado quantidade no estoque!");
	}
}
