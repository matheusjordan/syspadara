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

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "caixa_id")
	private Long id;
	
	@Column(name = "caixa_saldo", nullable = false)
	private double saldo;
	
	@Column(name = "caixa_rg", nullable = false, unique = true)
	private String rg;

	@OneToMany
	private List<Venda> vendas;

	// CONSTRUTORES
	public Caixa() {
	}

	public Caixa(double saldo, String rg) {
		this.saldo = saldo;
		this.rg = rg;
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public void addVenda(Venda venda) {
		this.vendas.add(venda);
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
}
