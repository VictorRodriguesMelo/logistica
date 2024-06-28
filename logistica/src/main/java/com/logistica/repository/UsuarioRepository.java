package com.logistica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logistica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	 @Query("SELECT s FROM Usuario s WHERE s.nome=?1")
	    Optional<Usuario> findUsuarioByName(Integer name);
}
