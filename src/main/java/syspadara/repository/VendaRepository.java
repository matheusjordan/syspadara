package syspadara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import syspadara.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
}
