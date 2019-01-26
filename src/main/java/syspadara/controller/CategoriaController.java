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

import syspadara.dto.cadastro.CategoriaDto;
import syspadara.model.Categoria;
import syspadara.service.CategoriaService;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping("{id}")
	public ResponseEntity<Categoria> readCategoria(@PathVariable(name = "id") Long id) {
		Categoria categoria = service.readCategoria(id);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	@PostMapping("novo")
	public ResponseEntity<Categoria> createCategoria(@RequestBody CategoriaDto cadastro) {
		service.createCategoria(cadastro);
		return new ResponseEntity<Categoria>(HttpStatus.CREATED);
	}

	@PutMapping("atualizacao")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		service.updateCategoria(categoria);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Categoria> deleteCategoria(@PathVariable(name = "id") Long id) {
		service.deleteCategoria(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/todos")
	public ResponseEntity<List<Categoria>> readAll() {
		List<Categoria> categorias = service.readAll();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

}
