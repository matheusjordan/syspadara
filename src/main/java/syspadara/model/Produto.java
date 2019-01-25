package syspadara.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 8757157320173883249L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nome", nullable = false, unique = true, length = 50)
	private String nome;
	
	@Column(name = "valor", nullable = false)
	private double valor;
	
	//CONSTRUTORES
	public Produto() {
	}
	
	public Produto(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	//METODOS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
