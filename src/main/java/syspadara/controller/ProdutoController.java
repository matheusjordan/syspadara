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

import syspadara.dto.produto.ProdutoCadastro;
import syspadara.model.Produto;
import syspadara.service.ProdutoService;

@Controller
@RequestMapping(path = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("{id}")
	public ResponseEntity<Produto> readProduto(@PathVariable(name = "id") Long id) {
		Produto produto = service.readProduto(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@PostMapping("novo")
	public ResponseEntity<Produto> createProduto(@RequestBody ProdutoCadastro cadastro) {
		service.createProduto(cadastro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("atualizacao")
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
		service.updateProduto(produto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Produto> removeProduto(@PathVariable(name = "id") Long id) {
		service.deleteProduto(id);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}

	@GetMapping("todos")
	public ResponseEntity<List<Produto>> listAll() {
		List<Produto> produtos = service.readAll();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

	@GetMapping("find/{nome}")
	public ResponseEntity<Produto> findByNome(@PathVariable(name = "nome") String nome) {
		Produto produto = service.findByNome(nome);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@GetMapping("find/all/{nome}")
	public ResponseEntity<List<Produto>> findAllByNome(@PathVariable(name = "nome") String nome) {
		List<Produto> produtos = service.findAllNomes(nome);
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

}
