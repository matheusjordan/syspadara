package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CadastroCategoria;
import syspadara.model.Categoria;
import syspadara.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	// Funções CRUD***
	public void createCategoria(CadastroCategoria cadastro) {
		
		//Recebe o valor de CadastroCategoria
		Categoria categoria = new Categoria();
		categoria.setNome(cadastro.getNome());
		
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
	
	public List<Categoria> readAll(){
		return repository.findAll();
	}
	
	public List<Categoria> findByNome(String nome){
		return repository.findByNome(nome);
	}
}
