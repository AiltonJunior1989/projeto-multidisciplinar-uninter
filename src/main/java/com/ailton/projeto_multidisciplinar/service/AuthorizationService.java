package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.infrastructure.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    private final UsuarioRepository repository;

    public AuthorizationService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        UserDetails user = repository.findByCpf(cpf);

        if(user == null){
           throw new UsernameNotFoundException("");
        }

        return user;

        //return repository.findByCpf(cpf);
    }
}
