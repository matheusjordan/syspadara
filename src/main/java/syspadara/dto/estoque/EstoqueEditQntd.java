package syspadara.dto.estoque;

import java.io.Serializable;

public class EstoqueEditQntd implements Serializable{

	private static final long serialVersionUID = 2073877021055439275L;
	
	private Long estoqueId;
	
	private Integer produtoQntd;
	
	//Construtores
	public EstoqueEditQntd() {}
	
	public EstoqueEditQntd(Long estoqueId, Integer produtoQntd) {
		this.estoqueId = estoqueId;
		this.produtoQntd = produtoQntd;
	}

	//Metodos Getts e Setts
	public Long getEstoqueId() {
		return estoqueId;
	}

	public void setEstoqueId(Long estoqueId) {
		this.estoqueId = estoqueId;
	}

	public Integer getProdutoQntd() {
		return produtoQntd;
	}

	public void setProdutoQntd(Integer produtoQntd) {
		this.produtoQntd = produtoQntd;
	}
	
	
}
