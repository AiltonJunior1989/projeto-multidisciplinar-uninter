package com.ailton.projeto_multidisciplinar.infrastructure.repository;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Override
    Optional<Produto> findById(Long id);
}
