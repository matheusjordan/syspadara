package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.produto.ProdutoCadastro;
import syspadara.dto.estoque.EstoqueCadastro;
import syspadara.model.Produto;
import syspadara.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private EstoqueService estoqueSer;
	
	//Funções CRUD***
	public void createProduto(ProdutoCadastro cadastro) {
		Produto produto = new Produto(cadastro.getNome(), cadastro.getValor());
		produtoRepo.save(produto);
		
		estoqueSer.createEstoque(new EstoqueCadastro(produto.getId(), cadastro.getQntd()));
		System.out.println("Criado");
	}
	
	public Produto readProduto(Long id) {
		return produtoRepo.findById(id).get();
	}
	
	public void updateProduto(Produto produto) {
		produtoRepo.save(produto);
		System.out.println("Atualizado");
	}
	
	public void deleteProduto(Long id) {
		Produto produto = produtoRepo.findById(id).get();
		produtoRepo.delete(produto);
		System.out.println("Deletado");
	}
	// *************
	
	public List<Produto> readAll(){
		return produtoRepo.findAll();
	}
	
	//Função para encontrar produtos pelo ID
	public List<Produto> findProdutos(List<Long> ids){
		List<Produto> produtos = produtoRepo.findAllById(ids);
		return produtos;
	}
	
	//Função para encontrar produto pelo ID
	public Produto findProduto(Long id) {
		return produtoRepo.findById(id).get();
	}
	
//	Revisar as funções abaixo Status -> < NOT OK >
//	public Produto findByNome(String nome) {
//		return produtoRepo.findByNome(nome);
//	}
	
	public List<Produto> findAllNomes(String nome){
		return produtoRepo.buscarProduto(nome);
	}
	
	//Retorna todos os Ids de uma lista de produtos
	public List<Long> readAllIds(List<Produto> produtos){
		List<Long> produtosIds = new ArrayList<>();
		
		for(Produto produto : produtos) {
			produtosIds.add(produto.getId());
		}
		
		return produtosIds;
	}
}
