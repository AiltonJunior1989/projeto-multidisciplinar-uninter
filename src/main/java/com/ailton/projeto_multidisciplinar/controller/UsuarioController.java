package com.ailton.projeto_multidisciplinar.controller;


import com.ailton.projeto_multidisciplinar.dtos.UsuarioDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import com.ailton.projeto_multidisciplinar.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
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
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioDTO dto){

        usuarioService.salvarUsuario(dto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Busca todos os usuários", description = "Busca todos ususario")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        List<UsuarioDTO> usuarios= usuarioService.buscarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Busca o usuário pelo CPF", description = "Busca o ususario pelo CPF")
    @GetMapping(path = "/{cpf}",params = "cpf")
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@RequestParam String cpf){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorCpf(cpf));
    }
}
