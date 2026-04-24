package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Pedido;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(Pedido pedido){
        return pedidoRepository.saveAndFlush(pedido);
    }

    public List<Pedido> buscarPedidos() {return pedidoRepository.findAll();}

    public List<Pedido> buscarPedidoPorCanal(String canalPedido){
        TipoCanalAtendimento tipo = TipoCanalAtendimento.valueOf(canalPedido.toUpperCase());
        return pedidoRepository.findByCanalPedido(tipo);
    }
}
