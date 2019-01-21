package syspadara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import syspadara.model.Produto;
import syspadara.service.ProdutoIService;

@Controller
public class MyController {

	@Autowired
	ProdutoIService produtoService;
	
	@RequestMapping("/showProdutos")
	public String findProdutos(Model model) {
		
		List<Produto> produtos = (List<Produto>) produtoService.findAll();
		
		model.addAttribute("produtos",produtos);
		
		return "showProdutos";
	}
}
