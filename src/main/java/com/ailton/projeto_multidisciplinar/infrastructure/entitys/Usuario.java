package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    //UM CLIENTE PODE TER VÁRIOS PEDIDOS
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //USUARIO do mappedBy é o atributo criado na Entyti usuário que faz relação com esta tabela
    //fetch type.lazy serve para trazer o essencial sempre que consultar a tabela de dados.
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    //O Set é parecido com o list que cria uma coleção, mas não aceita dados repetidos
    private Set<Pedido> pedidos = new HashSet<>();

    //nullable = false quer dizer que este campo será obrigatório o preenchimento de valor
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    //unique = true quer dizer que a coluna cpf não poderá conter valor repetido com outro usuário do mesmo cpf
    @Column(name = "cpf", unique = true)
    private String cpf;

    //updatable para não permitir a atualização deste campo.
    //@Column(name = "criado_em", updatable = false)
    //private LocalDateTime criado_em = LocalDateTime.now();

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criado_em;
}
