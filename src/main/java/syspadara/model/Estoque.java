package syspadara.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque implements Serializable{

	private static final long serialVersionUID = -7517280185333358149L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "valor", nullable = false)
	private Double valorEstoque;
	
	@Column(name = "produto", nullable = false, unique = true)
	private Produto produto;

	@Column(name = "produto_qntd", nullable = false)
	private Integer produtoQntd;

	//Construtores
	public Estoque() {};
	
	public Estoque(Produto produto, Integer produtoQntd) {
		this.produto = produto;
		this.produtoQntd = produtoQntd;
	}
	
	//Metodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getProdutoQntd() {
		return produtoQntd;
	}

	public void setProdutoQntd(Integer produtoQntd) {
		this.produtoQntd = produtoQntd;
	}

	public Double getValorEstoque() {
		return valorEstoque;
	}

	public void setValorEstoque(Double valorEstoque) {
		this.valorEstoque = valorEstoque;
	}
}
