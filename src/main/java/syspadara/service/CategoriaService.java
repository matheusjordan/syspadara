package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CategoriaDto;
import syspadara.model.Categoria;
import syspadara.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private ProdutoService produtoSer;

	// Funções CRUD***
	public void createCategoria(CategoriaDto cadastro) {
		// Dto utilizado possui uma Lista de Longs que será convertido em Produtos,
		// após passar pelo metodo findProdutos de ProdutoService
		Categoria categoria = new Categoria();

		categoria.setNome(cadastro.getNome());
		categoria.setProdutos(produtoSer.findProdutos(cadastro.getProdutosId()));

		this.repository.save(categoria);
		System.out.println("Cadastrado");
	}

	public Categoria readCategoria(Long id) {
		return repository.findById(id).get();
	}

	public void updateCategoria(Categoria categoria) {
		repository.save(categoria);
		System.out.println("Atualizado");
	}

	public void deleteCategoria(Long id) {
		repository.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	public List<Categoria> readAll() {
		return repository.findAll();
	}

	public List<Categoria> findByNome(String nome) {
		return repository.findByNome(nome);
	}
}
