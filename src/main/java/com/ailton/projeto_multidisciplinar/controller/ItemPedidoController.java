package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.ItemPedido;
import com.ailton.projeto_multidisciplinar.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/item")
@RequiredArgsConstructor
public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;

    @PostMapping
    ResponseEntity<Void> salvarItemPedido(@RequestBody ItemPedido pedido){
        itemPedidoService.salvarItemPedido(pedido);
        return ResponseEntity.ok().build();
    }
}
