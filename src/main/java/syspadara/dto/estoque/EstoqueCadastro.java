package syspadara.dto.estoque;

import java.io.Serializable;

public class EstoqueCadastro implements Serializable{

	private static final long serialVersionUID = -8906683158253748850L;
	private Long produtoId;
	private Integer qntd;
	
	//Constutores
	public EstoqueCadastro() {
	}
	
	public EstoqueCadastro(Long produtoId, Integer qntd) {
		this.produtoId = produtoId;
		this.qntd = qntd;
	}
	
	//Metodo
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	
	public Integer getQntd() {
		return qntd;
	}
	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}
}
