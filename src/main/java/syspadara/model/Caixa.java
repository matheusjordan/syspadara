package syspadara.model;

import java.io.Serializable;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "CAIXA")
public class Caixa implements Serializable {

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ID_VENDA")
	private int id_venda;

	@Column(name = "SALDO")
	private double saldo;

	private ArrayList<Venda> vendas;

	// CONSTRUTORES
	protected Caixa() {
	}

	public Caixa(int id, int id_venda, double saldo) {
		this.id = id;
		this.id_venda = id_venda;
		this.saldo = saldo;
	}

	// METODOS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	public void addVenda(Venda venda) {
		this.vendas.add(venda);
	}
}
