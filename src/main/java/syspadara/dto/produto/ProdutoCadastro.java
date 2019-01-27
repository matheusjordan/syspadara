package syspadara.dto.produto;

public class ProdutoCadastro {
	String nome;
	Double valor;
	Integer qntd;
	
	//Construtores
	public ProdutoCadastro() {}
	
	public ProdutoCadastro(String nome, Double valor, Integer qntd) {
		this.nome = nome;
		this.valor = valor;
		this.qntd = qntd;
	}
	
	//Metodos Getts e Setts
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQntd() {
		return qntd;
	}
	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}
	
}
