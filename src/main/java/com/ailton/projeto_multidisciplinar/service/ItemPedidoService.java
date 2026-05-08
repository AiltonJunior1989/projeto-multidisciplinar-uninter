package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.dtos.ItemPedidoDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.ItemPedido;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Pedido;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Produto;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.ItemPedidoRepository;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.PedidoRepository;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.ProdutoRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
public class ItemPedidoService {

        private final ItemPedidoRepository itemPedidoRepository;
        private final ProdutoRepository produtoRepository;
        private final PedidoRepository pedidoRepository;

        public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
            this.itemPedidoRepository = itemPedidoRepository;
            this.produtoRepository = produtoRepository;
            this.pedidoRepository = pedidoRepository;
        }

        public ItemPedido salvarItemPedido(ItemPedidoDTO dto) {
            Pedido pedido = pedidoRepository.findById(dto.pedidoId())
                    .orElseThrow(() ->
                            new RuntimeException("Pedido não encontrado"));

            Produto produto = produtoRepository.findById(dto.produtoId())
                    .orElseThrow(() ->
                            new RuntimeException("Produto não encontrado"));

            ItemPedido itemPedido = ItemPedido.builder()
                    .pedido(pedido)
                    .produto(produto)
                    .quantidade(dto.quantidade())
                    .build();

            return itemPedidoRepository.save(itemPedido);
        }

    //public List<ItemPedidoDTO> buscarItemPedido() {
       //return itemPedidoRepository.findAll()
       //        .stream()
       //        .map(item -> new ItemPedidoDTO(
       //                item.getId(),
       //                item.getQuantidade()
       //        )).toList();}
}
