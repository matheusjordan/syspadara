package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import syspadara.model.Produto;
import syspadara.repository.ProdutoRepository;

@Service
public class ProdutoService implements ProdutoIService{
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		
		List<Produto> produtos = (List<Produto>) repository.findAll();
		
		return produtos;
	}
}
