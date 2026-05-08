package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.dtos.ItemPedidoDTO;
import com.ailton.projeto_multidisciplinar.dtos.PedidoDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.ItemPedido;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Pedido;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Usuario;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.ItemPedidoRepository;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.PedidoRepository;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Pedido salvarPedido(PedidoDTO dto){

        List<ItemPedido> itens = dto.itens()
                                .stream()
                                .map(item -> itemPedidoRepository.findById(item.produtoId())
                                .orElseThrow(() -> new RuntimeException("Item não encontrado")))
                                .toList();

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(()
                        -> new RuntimeException("Usuário não encontrado"));

        Pedido pedido = Pedido.builder()
                .canalPedido(dto.canalPedido())
                .usuario(usuario)
                .itens(itens)
                .build();

        itens.forEach(i -> i.setPedido(pedido));
        return pedidoRepository.saveAndFlush(pedido);
    }

    public List<PedidoDTO> buscarPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedido -> new PedidoDTO(
                        pedido.getId(),
                        pedido.getCanalPedido(),
                        pedido.getItens()
                                .stream()
                                .map(item -> new ItemPedidoDTO(
                                        item.getProduto().getId(),
                                        item.getPedido().getId(),
                                        item.getQuantidade()
                                ))
                                .toList(),
                        pedido.getUsuario().getId()
                ))
                .toList();
    }

    public List<PedidoDTO> buscarPedidoPorCanal(String canalPedido){

        TipoCanalAtendimento tipo =
                TipoCanalAtendimento.valueOf(canalPedido.toUpperCase());

        return pedidoRepository.findByCanalPedido(tipo)
                .stream()
                .map(pedido -> new PedidoDTO(
                        pedido.getId(),
                        pedido.getCanalPedido(),
                        pedido.getItens()
                                .stream()
                                .map(item -> new ItemPedidoDTO(
                                        item.getProduto().getId(),
                                        item.getPedido().getId(),
                                        item.getQuantidade()
                                ))
                                .toList(),
                        pedido.getUsuario().getId()
                ))
                .toList();
    }
}
