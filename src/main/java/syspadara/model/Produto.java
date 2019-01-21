package syspadara.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "VALOR")
	private double valor;
	
	@Column(name = "QNTD")
	private int qntd;
	
	@Column(name = "CATEGORIA_ID")
	private int id_categoria;
	
	//CONSTRUTORES
	protected Produto() {
	}
	
	public Produto(int id,String nome, double valor, int qntd, int id_categoria) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qntd = qntd;
		this.id_categoria = id_categoria;
	}
	
	//METODOS
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
}
