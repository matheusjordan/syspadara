package syspadara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import syspadara.model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long>{
	
}
