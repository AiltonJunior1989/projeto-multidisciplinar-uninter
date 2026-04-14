package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Table(name = "produto")
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany( mappedBy = "produtos", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos = new HashSet<>();

    @Column(name = "nome")
    private String nome;

    // tipo de dados com número decimal, onde precision significa um total de 10 números com 2 dígitos após a vírgula
    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

}
