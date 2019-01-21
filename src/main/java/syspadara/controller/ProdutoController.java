package syspadara.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import syspadara.model.Produto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@RequestMapping("/Produto")
	public Produto getProduto(@RequestParam(value="id", defaultValue="1") 	int id) {
		return this.produtos.get(id-1);
	}
	
	@RequestMapping("/Produto/All")
	public List<Produto> getProdutos() {
		return this.produtos;
	}
}
