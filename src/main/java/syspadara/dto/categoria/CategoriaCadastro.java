package syspadara.dto.categoria;

import java.io.Serializable;
import java.util.List;

public class CategoriaCadastro implements Serializable{
	
	private static final long serialVersionUID = -4048648874222754581L;
	private String nome;
	private List<Long> produtosId;
	
	//Construtores
	public CategoriaCadastro() {}
	
	public CategoriaCadastro(String nome, List<Long> produtosId) {
		this.nome = nome;
		this.produtosId = produtosId;
	}
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Long> getProdutosId() {
		return produtosId;
	}
	public void setProdutosId(List<Long> produtosId) {
		this.produtosId = produtosId;
	}
}
