package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.cadastro.CadastroVenda;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public String createVenda(CadastroVenda cadastro) {
		Venda venda = new Venda();
		
		venda.setProdutos(produtoService.findProdutos(cadastro.getProdutos()));
//		venda.setValor(produtoService.ProdutosValorPorQuantidade(produtoService.findProdutos(cadastro.getProdutos()), cadastro.getQntds()));

		repository.save(venda);
		return "Criado";
	}
	
	public Venda readVenda(Long id) {
		return repository.findById(id).get();
	}
	
	public String updateVenda(Venda venda) {
		repository.save(venda);
		return "Atualizado";
	}
	
	public String deleteVenda(Long id) {
		Venda venda = repository.findById(id).get();
		repository.delete(venda);
		return "Deletado";
	}
	
	public List<Venda> readAll() {
		return repository.findAll();
	}
}
