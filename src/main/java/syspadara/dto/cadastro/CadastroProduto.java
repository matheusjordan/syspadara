package syspadara.dto.cadastro;

import java.io.Serializable;

//Dto com as informações essencias para a criação de um determinado produto
public class CadastroProduto implements Serializable{
	
	private String nome;
	
	private double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
