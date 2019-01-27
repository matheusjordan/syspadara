package syspadara.dto.caixa;

import java.io.Serializable;
import java.util.List;

public class CaixaAddVendas implements Serializable{

	private static final long serialVersionUID = -3522633148794316278L;
	private Long caixaId;
	private List<Long> vendasId;
	
	//Construtores
	public CaixaAddVendas() {}
	
	public CaixaAddVendas(Long caixaId, List<Long> vendasId) {
		this.caixaId = caixaId;
		this.vendasId = vendasId;
	}
	
	//MEtodos Getts e Setts
	public Long getCaixaId() {
		return caixaId;
	}
	public void setCaixaId(Long caixaId) {
		this.caixaId = caixaId;
	}
	public List<Long> getVendasId() {
		return vendasId;
	}
	public void setVendasId(List<Long> vendasId) {
		this.vendasId = vendasId;
	}
}
