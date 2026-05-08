package com.ailton.projeto_multidisciplinar.service;

import com.ailton.projeto_multidisciplinar.dtos.ProdutoDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Produto;
import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.Conflict;
import com.ailton.projeto_multidisciplinar.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(ProdutoDTO dto){

        if(dto.nome().isEmpty() || dto.precoUnitario().toString().isEmpty()){
            throw new Conflict("Preencha todos os campos.");
        }

        Produto produto = Produto.builder()
                        .nome(dto.nome())
                        .precoUnitario(dto.precoUnitario())
                        .build();

        repository.saveAndFlush(produto);
    }

    public List<ProdutoDTO> buscarTodosProdutos() {
        return repository.findAll()
                .stream()
                .map(produto -> new ProdutoDTO(
                        produto.getId(),
                        produto.getNome(),
                        produto.getPrecoUnitario()
                ))
                .toList();}
}
