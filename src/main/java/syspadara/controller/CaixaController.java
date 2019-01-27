package syspadara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import syspadara.dto.caixa.CaixaAddVendas;
import syspadara.dto.caixa.CaixaCadastro;
import syspadara.model.Caixa;
import syspadara.service.CaixaService;

@Controller
@RequestMapping("caixas")
public class CaixaController {

	@Autowired
	private CaixaService service;
	
	@ApiOperation(value = "Retorna os dados de um caixa")
	@GetMapping("{id}")
	public ResponseEntity<Caixa> readCaixa(@PathVariable(name = "id") Long id){
		Caixa caixa = service.readCaixa(id);
		return new ResponseEntity<Caixa>(caixa, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cria um caixa")
	@PostMapping("novo")
	public ResponseEntity<Caixa> createCaixa(@RequestBody CaixaCadastro cadastro){
		service.createCaixa(cadastro);
		return new ResponseEntity<Caixa>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualiza os dados de um caixa")
	@PutMapping("atualizacao")
	public ResponseEntity<Caixa> updateCaixa(@RequestBody Caixa caixa){
		service.updateCaixa(caixa);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Exclui um caixa")
	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Caixa> deleteCaixa(@PathVariable(name = "id") Long id){
		service.deleteCaixa(id);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna os dados de todos os caixas cadastrados")
	@GetMapping("todos")
	public ResponseEntity<List<Caixa>> readAll(){
		List<Caixa> caixas = service.readAll();
		return new ResponseEntity<List<Caixa>>(caixas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adicionar uma venda a um determinado caixa")
	@PutMapping("atualizacao/venda")
	public ResponseEntity<Caixa> addCaixaVenda(@RequestBody CaixaAddVendas addVendas){
		service.addVendas(addVendas);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
}
