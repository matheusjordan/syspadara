package syspadara.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import syspadara.model.Caixa;

@RestController
public class CaixaController {

	private List<Caixa> caixas = new ArrayList<Caixa>();
	
	{
		Caixa cx1 = new Caixa(1,1,20);
		Caixa cx2 = new Caixa(2,2,15);
		Caixa cx3 = new Caixa(3,3,10);
		
		this.caixas.add(cx1);
		this.caixas.add(cx2);
		this.caixas.add(cx3);
	}

	@RequestMapping("/Caixa")
	public Caixa getCaixa(@RequestParam(value = "id", defaultValue = "1") int id) {
		return this.caixas.get(id - 1);
	}

	@RequestMapping("/Caixa/All")
	public List<Caixa> getCaixas() {
		return this.caixas;
	}
}
