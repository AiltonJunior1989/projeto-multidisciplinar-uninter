package com.ailton.projeto_multidisciplinar.infrastructure.repository;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Usuario é o retorno do método
    //Optional evita o nullPointerException e toda vez que o usa há a obrigação de criar uma exceção caso o cpf não
    //exista
    //Padrão começar com findBy no caso o Cpf tem que ser identico ao atributo da entity.
    Optional<Usuario> findByCpf(String cpf);
}
