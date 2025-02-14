package com.logistica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logistica.entity.Frete;

public interface FreteRepository extends JpaRepository<Frete, Long>{
	
	 @Query("SELECT s FROM Frete s WHERE s.codigoFrete=?1")
	    Optional<Frete> findFreteByCodigoFrete(Integer codigoFrete);
}
