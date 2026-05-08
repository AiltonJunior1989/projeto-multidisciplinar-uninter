package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.dtos.UsuarioDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.Conflict;
import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.NotFound;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    // Injeção de dependência para manipular o objeto no banco de dados.
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    // public é o modificador de acesso e Significa que esse método pode ser chamado de qualquer lugar da aplicação.
    //void é o tipo de retorno
    // salvarUsuario é o nome do método
    //Usuario é o tipo do objeto e o usuario é o nome da variável a ser usada dentro do método
        public Usuario salvarUsuario(UsuarioDTO dto) {

            if(dto.cpf().isEmpty() || dto.nome().isEmpty() || dto.telefone().isEmpty()) {
                throw new Conflict("Preencha todos os campos para prosseguir.");
            }

            repository.findByCpf(dto.cpf())
                    .ifPresent(u -> {
                                throw new Conflict("CPF já cadastrado!");
                            }
                    );

            Usuario usuario = Usuario.builder()
                    .nome(dto.nome())
                    .telefone(dto.telefone())
                    .cpf(dto.cpf())
                    .build();

            return repository.saveAndFlush(usuario);
        }


    public Usuario buscarUsuarioPorCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(
                //caso o cpf não seja encontrado será lançado um erro que será pego no GlobalExceptionHandler
                //erro interno do servidor
                () -> new NotFound("CPF não encontrado!")
        );
    }

    public List<UsuarioDTO> buscarTodosUsuarios() {
        return repository.findAll()
                .stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getTelefone(),
                        usuario.getCpf()
                ))
                .toList();
    }
}
