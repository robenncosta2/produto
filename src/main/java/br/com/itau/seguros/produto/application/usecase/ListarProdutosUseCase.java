package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.List;

public interface ListarProdutosUseCase {

    List<Produto> findAllProdutos();
}
