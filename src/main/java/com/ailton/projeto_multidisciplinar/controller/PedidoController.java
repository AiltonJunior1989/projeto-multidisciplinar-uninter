package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Pedido;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import com.ailton.projeto_multidisciplinar.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> salvarPedido(@RequestBody Pedido pedido){
        pedidoService.salvarPedido(pedido);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarPedidos(){
        pedidoService.buscarPedidos();
        List<Pedido> pedidos = pedidoService.buscarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping(params = "canalPedido")
    public ResponseEntity<List<Pedido>> buscarPedidosPorCanal(@RequestParam String canalPedido){
        List<Pedido> pedidos = pedidoService.buscarPedidoPorCanal(canalPedido);
        return ResponseEntity.ok(pedidos);
    }
}
