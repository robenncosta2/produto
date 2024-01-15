package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.domain.model.Produto;

public class ProdutoRequestResponseMapper {

    public CreateProdutoResponse toCreateProdutoResponse(Produto produto) {

        return new CreateProdutoResponse(
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
}
