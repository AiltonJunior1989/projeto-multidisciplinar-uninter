package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.Conflict;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    // public é o modificador de acesso e Significa que esse método pode ser chamado de qualquer lugar da aplicação.
    //void é o tipo de retorno
    // salvarUsuario é o nome do método
    //Usuario é o tipo do objeto e o usuario é o nome da variável a ser usada dentro do método
    public void salvarUsuario(Usuario usuario){
        repository.findByCpf(usuario.getCpf())
                .ifPresent(u -> {
                    throw new Conflict("CPF já cadastrado!");
                }
        );


        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(
                //caso o cpf não seja encontrado será lançado um erro que será pego no GlobalExceptionHandler
                //erro interno do servidor
                () -> new RuntimeException("CPF não encontrado!")
        );
    }

    public List<Usuario> buscarTodosUsuarios() {return repository.findAll();}

}
