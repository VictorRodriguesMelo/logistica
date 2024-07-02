package com.logistica.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entity.Usuario;
import com.logistica.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuario() {
    	List<Usuario>  usuarios = usuarioRepository.findAll();
        return usuarios;
    }

	 public void addNewUsuario(Usuario usuario) { 
		Optional<Usuario> UsuarioOptional =usuarioRepository.findUsuarioByName(usuario.getCodigoUsuario());
		if(UsuarioOptional.isPresent()) {
			throw new IllegalStateException("email exist");
		} 
		usuarioRepository.save(usuario); 
	 }

    public void deleteUsuario(Long UsuarioId) {
        boolean exist = usuarioRepository.existsById(UsuarioId);
        if (!exist) {
            throw new IllegalStateException("Usuario with ID " + UsuarioId + " does not exist");
        }
        usuarioRepository.deleteById(UsuarioId);
    }

    @Transactional
    public void updateUsuario(Long UsuarioId, String name, Integer cod) {
        Usuario usuario = usuarioRepository.findById(UsuarioId)
                .orElseThrow(() -> new IllegalStateException("Usuario with ID " + UsuarioId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(name, usuario.getCodigoUsuario())) {
            usuario.setCodigoUsuario(null);
        }

        if (cod != null && !Objects.equals(cod, usuario.getCodigoUsuario())) {
            Optional<Usuario> UsuarioOptional = usuarioRepository.findUsuarioByName(cod);
            if (UsuarioOptional.isPresent()) {
                throw new IllegalStateException("email exist");
            }
            usuario.setCodigoUsuario(null);
        }

        usuarioRepository.save(usuario);

    }

}
