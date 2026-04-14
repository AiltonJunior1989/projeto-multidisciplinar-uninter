package com.ailton.projeto_multidisciplinar.controller;


import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import com.ailton.projeto_multidisciplinar.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@RequestParam String cpf){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        List<Usuario> usuarios= usuarioService.buscarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }



}
