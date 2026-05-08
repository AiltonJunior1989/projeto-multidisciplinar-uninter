package com.ailton.projeto_multidisciplinar.infrastructure.repository;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Pedido;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.TipoCanalAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//No repository adiciona o extends JpaRepository para fazer utilização dos métodos no banco de dados.
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // tipo de retorno
   List<Pedido>findByCanalPedido(TipoCanalAtendimento canalPedido);

}

