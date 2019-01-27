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
import syspadara.dto.categoria.CategoriaCadastro;
import syspadara.model.Categoria;
import syspadara.service.CategoriaService;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@ApiOperation(value = "Retorna os dados de uma categoria")
	@GetMapping("{id}")
	public ResponseEntity<Categoria> readCategoria(@PathVariable(name = "id") Long id) {
		Categoria categoria = service.readCategoria(id);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	@ApiOperation(value = "Cria uma nova categoria")
	@PostMapping("novo")
	public ResponseEntity<Categoria> createCategoria(@RequestBody CategoriaCadastro cadastro) {
		service.createCategoria(cadastro);
		return new ResponseEntity<Categoria>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualiza os dados de uma categoria")
	@PutMapping("atualizacao")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		service.updateCategoria(categoria);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta uma categoria")
	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Categoria> deleteCategoria(@PathVariable(name = "id") Long id) {
		service.deleteCategoria(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Exibe todas as categorias registradas")
	@GetMapping("/todos")
	public ResponseEntity<List<Categoria>> readAll() {
		List<Categoria> categorias = service.readAll();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

}
