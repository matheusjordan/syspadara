package syspadara.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import syspadara.model.Venda;

@RestController
public class VendaController {

	private List<Venda> vendas = new ArrayList<Venda>();

	{
		Venda vend1 = new Venda(1, 1, 4, 3.50);
		Venda vend2 = new Venda(2, 2, 3, 4.50);
		Venda vend3 = new Venda(3, 3, 2, 5.50);
		this.vendas.add(vend1);
		this.vendas.add(vend2);
		this.vendas.add(vend3);
	}

	@RequestMapping("/Venda")
	public Venda getVenda(@RequestParam(value = "id", defaultValue = "1") int id) {
		return this.vendas.get(id - 1);
	}

	@RequestMapping("/Venda/All")
	public List<Venda> getVendas() {
		return this.vendas;
	}
}
