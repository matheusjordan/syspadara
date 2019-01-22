package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.model.Categoria;
import syspadara.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public String createCategoria(Categoria categoria) {
		this.repository.save(categoria);
		return "Criado";
	}
	
	public Categoria readCategoria(Long id) {
		return repository.findById(id).get();
	}
	
	public String updateCategoria(Categoria categoria) {
		repository.save(categoria);
		return "Atualizado";
	}
	
	public String deleteCategoria(Long id) {
		repository.deleteById(id);
		return "Deletado";
	}
	
	public List<Categoria> readAll(){
		return repository.findAll();
	}
	
	public List<Categoria> findByNome(String nome){
		return repository.findByNome(nome);
	}
}
