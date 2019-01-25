package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.model.Estoque;
import syspadara.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepo;

	// Funções CRUD***
	public void createEstoque(Estoque estoque) {
		estoqueRepo.save(estoque);
		System.out.println("Criado");
	}

	public Estoque readEstoque(Long id) {
		return estoqueRepo.findById(id).get();
	}

	public void updateEstoque(Estoque estoque) {
		estoqueRepo.save(estoque);
		System.out.println("Atualizado");
	}

	public void deleteEstoque(Long id) {
		estoqueRepo.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	public List<Estoque> findAll() {
		return estoqueRepo.findAll();
	}
}
