package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CadastroProduto;
import syspadara.model.Produto;
import syspadara.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	//Funções CRUD***
	public void createProduto(CadastroProduto cadastro) {
		Produto produto = new Produto();
		produto.setNome(cadastro.getNome());
		produto.setValor(cadastro.getValor());
		repository.save(produto);
		System.out.println("Criado");
	}
	
	public Produto readProduto(Long id) {
		return repository.findById(id).get();
	}
	
	public void updateProduto(Produto produto) {
		repository.save(produto);
		System.out.println("Atualizado");
	}
	
	public void deleteProduto(Long id) {
		Produto produto = repository.findById(id).get();
		repository.delete(produto);
		System.out.println("Deletado");
	}
	// *************
	
	public List<Produto> readAll(){
		return repository.findAll();
	}
	
	//Função para encontrar produtos pelo ID
	public List<Produto> findProdutos(List<Long> ids){
		List<Produto> produtos = new ArrayList<>();
		
		for(Long id : ids) {
			produtos.add(repository.findById(id).get());
		}
		
		return produtos;
	}
	
	
	//Revisar as funções abaixo Status -> < NOT OK >
	public Produto findByNome(String nome) {
		return repository.findByNome(nome);
	}
	public List<Produto> findAllNomes(String nome){
		return repository.buscarProduto(nome);
	}
}
