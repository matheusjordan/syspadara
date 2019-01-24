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

import syspadara.dto.cadastro.CadastroCaixa;
import syspadara.model.Caixa;
import syspadara.service.CaixaService;

@Controller
@RequestMapping("caixas")
public class CaixaController {

	@Autowired
	private CaixaService service;
	
	@GetMapping("{id}")
	public ResponseEntity<Caixa> readCaixa(@PathVariable(name = "id") Long id){
		Caixa caixa = service.readCaixa(id);
		return new ResponseEntity<Caixa>(caixa, HttpStatus.OK);
	}
	
	@PostMapping("novo")
	public ResponseEntity<Caixa> createCaixa(@RequestBody CadastroCaixa dtoCaixa){
		service.createCaixa(dtoCaixa);
		return new ResponseEntity<Caixa>(HttpStatus.CREATED);
	}
	
	@PutMapping("atualizacao")
	public ResponseEntity<Caixa> updateCaixa(@RequestBody Caixa caixa){
		service.updateCaixa(caixa);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Caixa> deleteCaixa(@PathVariable(name = "id") Long id){
		service.deleteCaixa(id);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
	
	@GetMapping("todos")
	public ResponseEntity<List<Caixa>> readAll(){
		List<Caixa> caixas = service.readAll();
		return new ResponseEntity<List<Caixa>>(caixas, HttpStatus.OK);
	}
}
