package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.model.Caixa;
import syspadara.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	private CaixaRepository repository;
	
	// Funções CRUD***
	public void createCaixa(Caixa caixa) {
		repository.save(caixa);
		System.out.println("Criado");
	}
	
	public Caixa readCaixa(Long id) {
		Caixa caixa = repository.findById(id).get();
		return caixa;
	}
	
	public void updateCaixa(Caixa caixa) {
		repository.save(caixa);
		System.out.println("Atualizado");
	}
	
	public void deleteCaixa(Long id) {
		repository.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	public List<Caixa> readAll(){
		List<Caixa> caixas = repository.findAll();
		return caixas;
	}
}
