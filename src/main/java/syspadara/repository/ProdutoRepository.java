package syspadara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import syspadara.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findByNome(String nome);
	
	//01 Adicionado o nativeQuery, pois aparentemente o '*' nao estava sendo reconhecido
	//...como uma sintaxe válida
	//03 Função não está funcionando >:C e portanto será eliminada!
	//04 CONSSEGUI IMPLEMENTAR ESSA MERDA!!!!!
	//ERA SO USAR o @PathVariable no controller
	@Query(value = "select * from produto where produto_nome like %:name%",
			nativeQuery = true)
	List<Produto> buscarProduto(@Param("name") String nome);
	
}
