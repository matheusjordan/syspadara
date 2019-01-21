package syspadara.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "VENDA")
public class Venda implements Serializable {

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ID_PRODUTO")
	private int id_produto;

	@Column(name = "QNTD")
	private int qntd;

	@Column(name = "VALOR")
	private double valor;

	// CONSTRUTORES
	protected Venda() {
	}

	public Venda(int id, int id_produto, int qntd, double valor) {
		this.id = id;
		this.id_produto = id_produto;
		this.qntd = qntd;
		this.valor = valor;
	}

	// METODOS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getQntd() {
		return qntd;
	}

	public void setQntd(int qntd) {
		this.qntd = qntd;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
