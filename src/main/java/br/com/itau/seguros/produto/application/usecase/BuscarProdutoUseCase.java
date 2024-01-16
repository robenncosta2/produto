package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.Optional;

public interface BuscarProdutoUseCase {

    Optional<Produto> getProdutoById(String id);
}
