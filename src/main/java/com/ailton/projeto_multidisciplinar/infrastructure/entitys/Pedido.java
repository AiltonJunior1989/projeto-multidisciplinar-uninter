package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    //relação de muitos para um com a tabela USUARIO
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    //Anotação de relação de muitos para muitos com a entity produto
    @ManyToMany
    @JoinTable(
            name = "item_pedido",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
    private Set<Produto> produtos = new HashSet<>();

    //Este campo na tabela será do tipo Enum, com padrões já definidos de dados
    //Foi criado um pacote de enums dentro do pacote entitys e criado um arquido do tipo enum chamado TipoCanalAtendimento
    //que está a ser usado aqui.
    @Column(name = "canalPedido")
    @Enumerated(EnumType.STRING)
    private TipoCanalAtendimento canalPedido;

    @Column(name = "dataPedido")
    private LocalDate dataPedido;
}
