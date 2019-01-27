package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.categoria.CategoriaCadastro;
import syspadara.model.Categoria;
import syspadara.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private ProdutoService produtoSer;

	// Funções CRUD***
	public void createCategoria(CategoriaCadastro cadastro) {
		// Dto utilizado possui uma Lista de Longs que será convertido em Produtos,
		// após passar pelo metodo findProdutos de ProdutoService
		Categoria categoria = new Categoria();

		categoria.setNome(cadastro.getNome());
		categoria.setProdutos(produtoSer.findProdutos(cadastro.getProdutosId()));

		this.categoriaRepo.save(categoria);
		System.out.println("Cadastrado");
	}

	public Categoria readCategoria(Long id) {
		return categoriaRepo.findById(id).get();
	}

	public void updateCategoria(Categoria categoria) {
		categoriaRepo.save(categoria);
		System.out.println("Atualizado");
	}

	public void deleteCategoria(Long id) {
		categoriaRepo.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	public List<Categoria> readAll() {
		return categoriaRepo.findAll();
	}

	public List<Categoria> findByNome(String nome) {
		return categoriaRepo.findByNome(nome);
	}
}
