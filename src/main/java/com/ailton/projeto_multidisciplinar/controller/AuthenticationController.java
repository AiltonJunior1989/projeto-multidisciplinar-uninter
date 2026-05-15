package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.dtos.AuthenticationDTO;
import com.ailton.projeto_multidisciplinar.dtos.LoginResponseDTO;
import com.ailton.projeto_multidisciplinar.dtos.RegisterDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.Conflict;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.UsuarioRepository;
import com.ailton.projeto_multidisciplinar.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository repository;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, UsuarioRepository repository, TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.cpf(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(repository.findByCpf(data.cpf()) != null){
           // return ResponseEntity.badRequest().build();
            throw new Conflict("Usuário já cadastrado.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.nome(), data.telefone(),data.cpf(), encryptedPassword, data.role());

        repository.save(newUser);
        return ResponseEntity.ok().build();

    }
}
