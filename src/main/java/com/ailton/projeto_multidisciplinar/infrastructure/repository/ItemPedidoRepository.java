package com.ailton.projeto_multidisciplinar.infrastructure.repository;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
