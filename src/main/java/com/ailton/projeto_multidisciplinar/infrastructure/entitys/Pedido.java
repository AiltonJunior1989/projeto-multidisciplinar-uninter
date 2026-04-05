package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Table(name = "pedido")
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Este campo na tabela será do tipo Enum, com padrões já definidos de dados
    //Foi criado um pacote de enums dentro do pacote entitys e criado um arquido do tipo enum chamado TipoCanalAtendimento
    //que está a ser usado aqui.
    @Column(name = "canalPedido")
    @Enumerated(EnumType.STRING)
    private TipoCanalAtendimento canalPedido;

    @Column(name = "dataPedido")
    private LocalDate dataPedido;
}
