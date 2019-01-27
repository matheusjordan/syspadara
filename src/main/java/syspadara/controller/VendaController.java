package syspadara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import syspadara.dto.venda.VendaCadastro;
import syspadara.model.Venda;
import syspadara.service.VendaService;

@Controller
@RequestMapping("vendas")
public class VendaController {

	@Autowired
	private VendaService service;
	
	@ApiOperation(value = "Retorna os dados de uma venda")
	@GetMapping("{id}")
	public ResponseEntity<Venda> readVenda(@PathVariable(name = "id") Long id){
		Venda venda = service.readVenda(id);
		return new ResponseEntity<Venda>(venda, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cria uma venda")
	@RequestMapping("novo")
	public ResponseEntity<Venda> createVenda(@RequestBody VendaCadastro cadastro){
		service.createVenda(cadastro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualiza os dados de uma venda")
	@PutMapping("atualizacao")
	public ResponseEntity<Venda> updateVenda(@RequestBody Venda venda){
		service.updateVenda(venda);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Exclui uma venda")
	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Venda> deleteVenda(@PathVariable(name = "id") Long id){
		service.deleteVenda(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna os dados de  todas as vendas")
	@RequestMapping("todos")
	public ResponseEntity<List<Venda>> readAll(){
		List<Venda> vendas = service.readAll();
		return new ResponseEntity<List<Venda>>(vendas, HttpStatus.OK);
	}
}
