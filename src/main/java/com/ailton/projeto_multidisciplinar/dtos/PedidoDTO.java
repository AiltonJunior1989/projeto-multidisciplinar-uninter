package com.ailton.projeto_multidisciplinar.dtos;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;

import java.util.List;

public record PedidoDTO(Long id,
                        TipoCanalAtendimento canalPedido,
                        List<ItemPedidoDTO> itens,
                        Long usuarioId) {
}
