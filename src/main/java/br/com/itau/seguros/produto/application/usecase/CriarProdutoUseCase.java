package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.domain.model.Produto;

public interface CriarProdutoUseCase {

    Produto createProduto(Produto produto);
}
