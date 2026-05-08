package com.ailton.projeto_multidisciplinar.infrastructure.repository;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
