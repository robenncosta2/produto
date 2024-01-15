package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.domain.model.Produto;

public interface CriarProdutoInteractor {

    Produto createProduto(Produto produto);
}
