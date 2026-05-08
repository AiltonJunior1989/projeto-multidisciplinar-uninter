package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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
    private Long id;

    //Este campo na tabela será do tipo Enum, com padrões já definidos de dados
    //Foi criado um pacote de enums dentro do pacote entitys e criado um arquido do tipo enum chamado TipoCanalAtendimento
    //que está a ser usado aqui.
    //@Column mesmo colocando o nome = canalPedido, no banco de dados será criado o nome como canal_pedido.
    @Column(name = "canalPedido")
    @Enumerated(EnumType.STRING)
    private TipoCanalAtendimento canalPedido;

    @CreationTimestamp
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemPedido> itens;


    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //Relação de vários pedidos para um usuário
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
