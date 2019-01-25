package syspadara.dto.cadastro;

import java.io.Serializable;
import java.util.List;

//DTO para cadastrar vendas
public class CadastroVenda implements Serializable{
	private List<Long> produtos;
	
//	private List<Integer> qntds;

	public List<Long> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Long> produtos) {
		this.produtos = produtos;
	}

//	public List<Integer> getQntds() {
//		return qntds;
//	}
//
//	public void setQntds(List<Integer> qntds) {
//		this.qntds = qntds;
//	}
}
