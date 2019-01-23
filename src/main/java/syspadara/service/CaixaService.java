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
	
	public String createCaixa(Caixa caixa) {
		
		if(caixa.getRg().length() != 3) {
			return "Nao criado";
		}
		
		repository.save(caixa);
		return "Criado";
	}
	
	public Caixa readCaixa(Long id) {
		Caixa caixa = repository.findById(id).get();
		return caixa;
	}
	
	public String updateCaixa(Caixa caixa) {
		repository.save(caixa);
		return "Atualizado";
	}
	
	public String deleteCaixa(Long id) {
		repository.deleteById(id);
		return "Deletado";
	}
	
	public List<Caixa> readAll(){
		List<Caixa> caixas = repository.findAll();
		return caixas;
	}
}
