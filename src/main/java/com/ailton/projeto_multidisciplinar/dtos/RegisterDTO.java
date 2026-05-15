package com.ailton.projeto_multidisciplinar.dtos;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.UserRole;

public record RegisterDTO(String nome,
                          String telefone,
                          String cpf,
                          String password,
                          UserRole role) {
}
