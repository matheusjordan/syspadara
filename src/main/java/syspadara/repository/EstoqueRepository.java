package syspadara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import syspadara.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	Estoque findProdutoQntdByProdutoId(Long id);
	Estoque findEstoqueByProdutoId(Long id);
	Estoque findProdutoIdById(Long id);
}
