package syspadara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Caixa implements Serializable {
	
	private static final long serialVersionUID = -7867335362151450132L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caixa_id")
	private Long id;
	
	@Column(name = "caixa_saldo", nullable = false)
	private double saldo;

	@OneToMany
	private List<Venda> vendas;

	// CONSTRUTORES
	public Caixa() {
	}

	public Caixa(List<Venda> vendas) {
		this.vendas = vendas;
	}

	// METODOS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
}
