package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    @Column(name = "nome")
    private String nome;

    // tipo de dados com número decimal, onde precision significa um total de 10 números com 2 dígitos após a vírgula
    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

}
