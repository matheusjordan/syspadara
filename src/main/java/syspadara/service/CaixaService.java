package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CadastroCaixa;
import syspadara.model.Caixa;
import syspadara.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	private CaixaRepository repository;
	
	public void createCaixa(CadastroCaixa cadastro) {
		
		//ciaxa recebe o valor do dto CadastroCaixa
		Caixa caixa = new Caixa();
		caixa.setRg(cadastro.getRg());
		
		repository.save(caixa);
		System.out.println("Cadastrado");
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
