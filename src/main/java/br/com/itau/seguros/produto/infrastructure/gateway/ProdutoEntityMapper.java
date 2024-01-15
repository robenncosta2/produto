package br.com.itau.seguros.produto.infrastructure.gateway;

import br.com.itau.seguros.produto.domain.model.Produto;
import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoEntity;

public class ProdutoEntityMapper {

    public ProdutoEntity toProdutoEntity(Produto produto) {

        return new ProdutoEntity(
            null,
            produto.nome(),
            produto.categoria(),
            produto.precoBase(),
            produto.precoTarifado()
        );
    }

    public Produto toProduto(ProdutoEntity produtoEntity) {

        return new Produto(
            produtoEntity.id(),
            produtoEntity.nome(),
            produtoEntity.categoria(),
            produtoEntity.precoBase(),
            produtoEntity.precoTarifado()
        );
    }
}
