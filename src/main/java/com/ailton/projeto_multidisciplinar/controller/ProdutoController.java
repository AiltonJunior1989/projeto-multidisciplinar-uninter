package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.dtos.ProdutoDTO;
import com.ailton.projeto_multidisciplinar.infrastructure.entitys.Produto;
import com.ailton.projeto_multidisciplinar.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody ProdutoDTO dto){
        produtoService.salvarProduto(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos() {
        List<ProdutoDTO> produtos = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }
}
