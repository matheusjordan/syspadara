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
	
	@Column(name = "produto_id", nullable = false, unique = true)
	private Long produtoId;

	@Column(name = "produto_qntd", nullable = false)
	private Integer produtoQntd;

	//Construtores
	public Estoque() {};
	
	public Estoque(Long produtoId, Integer produtoQntd) {
		this.produtoId = produtoId;
		this.produtoQntd = produtoQntd;
	}
	
	//Metodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getProdutoQntd() {
		return produtoQntd;
	}

	public void setProdutoQntd(Integer produtoQntd) {
		this.produtoQntd = produtoQntd;
	}
}
