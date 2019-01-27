package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.caixa.CaixaAddVendas;
import syspadara.dto.caixa.CaixaCadastro;
import syspadara.model.Caixa;
import syspadara.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	private CaixaRepository repository;
	
	@Autowired
	private VendaService vendaSer;
	
	// Funções CRUD***
	public void createCaixa(CaixaCadastro cadastro) {
		Caixa caixa = new Caixa();
		caixa.setVendas(vendaSer.findVendas(cadastro.getVendasId()));
		
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
	
	//Adiciona uma venda à uma Entidade Caixa
	public void addVendas(CaixaAddVendas addVendas) {
		//Encontra o Objeto venda através do ID
		Caixa caixa = repository.findById(addVendas.getCaixaId()).get();
		
		//é percorrido cada index da lista de vendas dentro do DTO addVenda
		for(int i=0; i < addVendas.getVendasId().size(); i++) {
			
			//Adiciona a lista de vendas do objeto as vendas do addVendas
			caixa.addVenda(vendaSer.findVenda(addVendas.getVendasId().get(i))); 
		}
		
		this.updateCaixa(caixa);
		System.out.println("Adicionado Vendas");
	}
}
