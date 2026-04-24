package com.ailton.projeto_multidisciplinar.dtos;

import java.math.BigDecimal;

public record ProdutoDTO(   Integer id,
                            String nome,
                            BigDecimal precoUnitario) {
}
