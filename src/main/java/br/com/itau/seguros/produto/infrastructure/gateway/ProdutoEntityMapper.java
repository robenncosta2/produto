package br.com.itau.seguros.produto.infrastructure.gateway;

import br.com.itau.seguros.produto.domain.model.Produto;
import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoEntity;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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

    public Optional<Produto> toProdutoOptional(Optional<ProdutoEntity> produtoEntityOptional) {

        if (produtoEntityOptional.isEmpty()) {
            return Optional.empty();
        }

        var produtoValue = produtoEntityOptional.get();

        return Optional.of(new Produto(
            produtoValue.id(),
            produtoValue.nome(),
            produtoValue.categoria(),
            produtoValue.precoBase(),
            produtoValue.precoTarifado()
        ));
    }

    public List<Produto> toProdutos(List<ProdutoEntity> produtosEntity) {

        return produtosEntity.stream().map(produtoEntity -> new Produto(
            produtoEntity.id(),
            produtoEntity.nome(),
            produtoEntity.categoria(),
            produtoEntity.precoBase(),
            produtoEntity.precoTarifado()
        )).collect(toList());
    }
}
