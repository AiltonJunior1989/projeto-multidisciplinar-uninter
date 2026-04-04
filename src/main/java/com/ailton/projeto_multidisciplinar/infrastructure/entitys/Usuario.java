package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// getter e setter para acessar ou modificar os atributos
@Getter
@Setter
//@AllArgsConstructor, @NoArgsConstructor para acessar a classe.
@AllArgsConstructor
@NoArgsConstructor
//Implementa o padrão de projeto Builder para facilitar
//a criação de objetos de forma fluente.
@Builder
//@Table para colocar o nome da tabela no banco de dados
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //nullable = false quer dizer que este campo será obrigatório o preenchimento de valor
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    //unique = true quer dizer que a coluna cpf não poderá conter valor repetido com outro usuário do mesmo cpf
    @Column(name = "cpf", unique = true)
    private String cpf;

    //updatable para não permitir a atualização deste campo.
    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criado_em = LocalDateTime.now();
}
