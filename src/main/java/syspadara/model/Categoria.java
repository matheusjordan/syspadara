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

	private static final long serialVersionUID = -4716038753114460847L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = false, unique = true, length = 100)
	private String nome;
	
	@OneToMany
	@JoinColumn(name = "categoria_id")
	private List<Produto> produtos;
	
	//CONSTRUTORES
	public Categoria() {
	}
	
	public Categoria(String nome, List<Produto> produtos) {
		this.nome = nome;
		this.produtos = produtos;
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
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
