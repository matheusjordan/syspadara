package syspadara.dto.caixa;

import java.io.Serializable;
import java.util.List;

public class CaixaCadastro implements Serializable{

	private static final long serialVersionUID = -3888977723272772703L;
	
	List<Long> vendasId;

	public List<Long> getVendasId() {
		return vendasId;
	}

	public void setVendasId(List<Long> vendasId) {
		this.vendasId = vendasId;
	}
}
