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
	
//	@Query("SELECT * FROM produto WHERE produto_nome LIKE %:nome%")
//	List<Produto> findAllByNome(@Param(value = "nome") String nome);
	
}
