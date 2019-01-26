package syspadara.dto.cadastro;

import java.io.Serializable;
import java.util.List;

public class CaixaDto implements Serializable{

	private static final long serialVersionUID = -3888977723272772703L;
	List<Long> VendasId;

	public List<Long> getVendasId() {
		return VendasId;
	}

	public void setVendasId(List<Long> vendasId) {
		VendasId = vendasId;
	}
}
