package syspadara.controller;

import syspadara.model.Categoria;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CategoriaController {
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	{
		Categoria cat1 = new Categoria(1,"Salgados",1);
		Categoria cat2 = new Categoria(2,"Doces",1);
		Categoria cat3 = new Categoria(3,"Bebidas",1);
		this.categorias.add(cat1);
		this.categorias.add(cat2);
		this.categorias.add(cat3);
	}
	
	@RequestMapping("/Categoria")
	public Categoria getCategoria(@RequestParam(value = "id", defaultValue="1")int id) {
		return this.categorias.get(id -1);
	}
	
	@RequestMapping("/Categoria/All")
	public List<Categoria> getCategorias(){
		return this.categorias;
	}
}
