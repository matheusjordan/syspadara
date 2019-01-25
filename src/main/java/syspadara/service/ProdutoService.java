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
	
	public String createProduto(CadastroProduto cadastro) {
		Produto produto = new Produto();
		produto.setNome(cadastro.getNome());
		produto.setValor(cadastro.getValor());
		repository.save(produto);
		return "Criado";
	}
	
	public Produto readProduto(Long id) {
		return repository.findById(id).get();
	}
	
	public String updateProduto(Produto produto) {
		repository.save(produto);
		return "Atualizado";
	}
	
	//Ao excluir será exibido "Deletado" no console
	public void deleteProduto(Long id) {
		Produto produto = repository.findById(id).get();
		repository.delete(produto);
		System.out.println("Deletado");
	}
	
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
	
	public Produto findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
//	public List<Produto> findFind(String nome){
//		return repository.findAllByNome(nome);
//	}
	
	//Função para retornar o valor total de uma lista de produtos
	//total = valor * qntd
//	public double ProdutosValorPorQuantidade(List<Produto> produtos, List<Integer> qntds) {
//		double total = 0;
//		int index = 0;
//		
//		for(Produto produto: produtos) {
//			total += (qntds.get(index) * produto.getValor());
//		}
//		
//		return total;
//	}
}
