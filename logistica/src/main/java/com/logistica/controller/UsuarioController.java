package com.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.entity.Usuario;
import com.logistica.service.UsuarioService;


@RestController
@RequestMapping(path = "usuario")
public class UsuarioController {
	
	@Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getusuario")
    public List<Usuario> getUsuario() {
        return usuarioService.getUsuario();
    }

    @PostMapping
    @Transactional
    public void registerUsuario(@RequestBody Usuario usuario) {
        usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping("{usuarioid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteUsuario(@PathVariable("usuarioid") Long usuarioid) {
        usuarioService.deleteUsuario(usuarioid);
    }

    @PutMapping("{putid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updateUsuario(@PathVariable("putid") Long usuarioid,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Integer codigo){
        usuarioService.updateUsuario(usuarioid, name, codigo);
    }
}
