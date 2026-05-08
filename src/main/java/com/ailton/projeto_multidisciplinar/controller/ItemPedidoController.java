package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.dtos.ItemPedidoDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.ItemPedido;
import com.ailton.projeto_multidisciplinar.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/item")
@RequiredArgsConstructor
public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;

    @PostMapping
    ResponseEntity<Void> salvarItemPedido(@RequestBody ItemPedidoDTO dto){
        itemPedidoService.salvarItemPedido(dto);
        return ResponseEntity.ok().build();
    }

    //@GetMapping
    //ResponseEntity<List<ItemPedidoDTO>> buscarItemPedidos(){
   //     List<ItemPedido> itens = itemPedidoService.buscarItemPedido();
   //     return ResponseEntity.ok(itens);
   // }
}
