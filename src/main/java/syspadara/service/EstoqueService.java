package syspadara.service;

import java.util.ArrayList;
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
	
	// Funções CRUD***
	public void createEstoque(EstoqueCadastro cadastro) {
		Estoque estoque = new Estoque();
		
		estoque.setProdutoId(cadastro.getProdutoId());
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
	
	//Função que retorna o ID do estoque de um produto por seu id
	public Long findEstoqueId(Long id) {
		return estoqueRepo.findEstoqueByProdutoId(id).getId();
	}
	
	//Função que retorna o estoque de um produto pelo ID
	public Integer findProdutoEstoque(Long id) {
		return estoqueRepo.findProdutoQntdByProdutoId(id).getProdutoQntd();
	}
	
	//Função para alterar a quantidade de um produto no estoque
	public void editQntd(EstoqueEditQntd editQntd) {
		Estoque estoque = new Estoque();
		Long produtoId = this.findProdutoId(editQntd.getEstoqueId());
		
		estoque.setId(editQntd.getEstoqueId());
		estoque.setProdutoId(produtoId);
		estoque.setProdutoQntd(editQntd.getProdutoQntd());
		
		estoqueRepo.save(estoque);
		System.out.println("Atualizado quantidade no estoque!");
	}
	
	//Função para retornar os Ids dos produtos cadastrados no estoque
	public List<Long> findProdutosId() {
		List<Long> produtosId = new ArrayList<>();
		for(int i=0; i<estoqueRepo.findAll().size(); i++) {
			produtosId.add(estoqueRepo.findAll().get(i).getProdutoId());
		}
		return produtosId;	
	}
	
	//Função para reotnra o id de um produto cadastrado no estoque
	public Long findProdutoId(Long id) {
		return estoqueRepo.findProdutoIdById(id).getProdutoId();
	}
}
