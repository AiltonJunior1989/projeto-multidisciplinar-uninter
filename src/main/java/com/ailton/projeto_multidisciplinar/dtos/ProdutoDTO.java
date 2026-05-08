package com.ailton.projeto_multidisciplinar.dtos;

import java.math.BigDecimal;

public record ProdutoDTO(   Long produtoId,
                            String nome,
                            BigDecimal precoUnitario) {
}
