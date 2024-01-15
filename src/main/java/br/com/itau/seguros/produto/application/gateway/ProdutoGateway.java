package br.com.itau.seguros.produto.application.gateway;

import br.com.itau.seguros.produto.domain.model.Produto;

public interface ProdutoGateway {

    Produto createProduto(Produto produto);
}
