package syspadara.dto.venda;

import java.io.Serializable;
import java.util.List;

public class VendaCadastro implements Serializable{

	private static final long serialVersionUID = 4923813067800086493L;
	
	private List<Long> produtosId;
	private List<Integer> produtosQntd;
	
	//Construtores
	private VendaCadastro() {};
	
	private VendaCadastro(List<Long> produtosId, List<Integer> produtosQntd) {
		this.produtosId = produtosId;
		this.produtosQntd = produtosQntd;
	}
	
	//Metodos Getts e Setts
	public List<Long> getProdutosId() {
		return produtosId;
	}
	public void setProdutosId(List<Long> produtosId) {
		this.produtosId = produtosId;
	}
	public List<Integer> getProdutosQntd() {
		return produtosQntd;
	}
	public void setProdutosQntd(List<Integer> produtosQntd) {
		this.produtosQntd = produtosQntd;
	}
}
