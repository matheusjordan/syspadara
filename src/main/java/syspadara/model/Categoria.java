package syspadara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "categoria_id")
	private Long id;
	
	@Column(name = "categoria_nome", nullable = false, unique = true, length = 20)
	private String nome;
	
	@Column(name = "categoria_status", nullable = false, length = 1)
	private int status;
	
	@OneToMany
	@JoinColumn(name = "categoria_id")
	private List<Produto> produtos;
	
	//CONSTRUTORES
	public Categoria() {
	}
	
	public Categoria(String nome, int status) {
		this.nome = nome;
		this.status = status;
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
