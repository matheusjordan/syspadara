package syspadara.repository;

import org.springframework.data.repository.CrudRepository;

import syspadara.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
