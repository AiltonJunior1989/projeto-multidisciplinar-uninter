package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.ItemPedido;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.saveAndFlush(itemPedido);
    }
}
