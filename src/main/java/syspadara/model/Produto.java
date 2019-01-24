package syspadara.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "produto_id")
	private Long id;

	@Column(name = "produto_nome", nullable = false, unique = true, length = 50)
	private String nome;
	
	@Column(name = "produto_valor", nullable = false)
	private double valor;
	
	@Column(name = "produto_qntd", nullable = false)
	private int qntd;
	
	//CONSTRUTORES
	public Produto() {
	}
	
	public Produto(String nome, double valor, int qntd, int id_categoria) {
		this.nome = nome;
		this.valor = valor;
		this.qntd = qntd;
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
	
	public int getQntd() {
		return qntd;
	}
	public void setQntd(int qntd) {
		this.qntd = qntd;
	}

}
