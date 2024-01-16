package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.Optional;

public class BuscarProdutoUseCaseImpl implements BuscarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public Optional<Produto> getProdutoById(String id) {
        return produtoGateway.getProdutoById(id);
    }
}
