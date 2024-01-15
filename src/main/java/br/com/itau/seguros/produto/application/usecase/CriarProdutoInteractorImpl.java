package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.application.usecase.preco.CalculadorDePrecoInteractor;
import br.com.itau.seguros.produto.domain.model.Produto;

public class CriarProdutoInteractorImpl implements CriarProdutoInteractor {

    private final ProdutoGateway produtoGateway;
    private final CalculadorDePrecoInteractor calculadorDePrecoInteractor;

    public CriarProdutoInteractorImpl(ProdutoGateway produtoGateway, CalculadorDePrecoInteractor calculadorDePrecoInteractor) {
        this.produtoGateway = produtoGateway;
        this.calculadorDePrecoInteractor = calculadorDePrecoInteractor;
    }

    @Override
    public Produto createProduto(Produto produto) {

        var precoTarifado = calculadorDePrecoInteractor.calcularPrecoTarifado(
            produto.precoBase(),
            produto.categoria()
        );

        var produtoComPrecoTarifado = new Produto(
            produto.id(),
            produto.nome(),
            produto.categoria(),
            produto.precoBase(),
            precoTarifado
        );

        return produtoGateway.createProduto(produtoComPrecoTarifado);
    }
}
