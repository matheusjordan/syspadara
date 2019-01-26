package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CaixaDto;
import syspadara.model.Caixa;
import syspadara.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	private CaixaRepository repository;
	
	@Autowired
	private VendaService vendaSer;
	
	// Funções CRUD***
	public void createCaixa(CaixaDto cadastro) {
		Caixa caixa = new Caixa();
		caixa.setVendas(vendaSer.findVendas(cadastro.getVendasId()));
		
		double valor = 0;
		for(int i=0; i< caixa.getVendas().size(); i++) {
			valor += caixa.getVendas().get(i).getValor();
		}

		caixa.setSaldo(valor);
		
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
