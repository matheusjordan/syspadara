package syspadara.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "CAIXA")
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private double saldo;
	
	@OneToMany
	private List<Venda> vendas;

	// CONSTRUTORES
	protected Caixa() {
	}

	public Caixa(int id, int id_venda, double saldo) {
		this.id = id;
		this.saldo = saldo;
	}

	// METODOS
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
}
