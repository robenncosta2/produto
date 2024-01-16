package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ProdutoDataMapper {

    public ProdutoResponse toProdutoResponse(Produto produto) {

        return new ProdutoResponse(
            produto.id(),
            produto.nome(),
            produto.categoria(),
            produto.precoBase(),
            produto.precoTarifado()
        );
    }

    public Produto toCreateProduto(CreateProdutoRequest createProdutoRequest) {

        return new Produto(
            null,
            createProdutoRequest.nome(),
            createProdutoRequest.categoria(),
            createProdutoRequest.precoBase(),
            null
        );
    }

    public List<ProdutoResponse> toListOfProdutos(List<Produto> produtos) {

        return produtos.stream().map(produto -> new ProdutoResponse(
             produto.id(),
             produto.nome(),
             produto.categoria(),
             produto.precoBase(),
             produto.precoTarifado()
        )).collect(toList());
    }
}
