package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.List;

public class ListarProdutoUseCaseImpl implements ListarProdutosUseCase {

    private final ProdutoGateway produtoGateway;

    public ListarProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public List<Produto> findAllProdutos() {
        return produtoGateway.findAllProdutos();
    }
}
 