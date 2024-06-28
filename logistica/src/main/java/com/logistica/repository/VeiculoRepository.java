package com.logistica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logistica.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	 @Query("SELECT s FROM Veiculo s WHERE s.name=?1")
	    Optional<Veiculo> findVeiculoByEmail(String email);
}
