package syspadara.service;

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
}
