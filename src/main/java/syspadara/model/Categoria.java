package syspadara.model;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	private String nome;
	private int status;
	
	@OneToMany
	private List<Produto> produtos;
	
	//CONSTRUTORES
	protected Categoria() {
	}
	
	public Categoria(int id, String nome, int status) {
		this.id = id;
		this.nome = nome;
		this.status = status;
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
	public void setTipo(String nome) {
		this.nome = nome;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
}
