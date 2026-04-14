package com.ailton.projeto_multidisciplinar.infrastructure.repository;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

//No repository adiciona o extends JpaRepository para fazer utilização dos métodos no banco de dados.
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    // tipo de retorno
    Pedido findPedidoByCanalPedido(String canal_pedido);

}

