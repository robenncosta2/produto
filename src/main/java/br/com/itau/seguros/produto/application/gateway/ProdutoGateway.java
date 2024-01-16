package br.com.itau.seguros.produto.application.gateway;

import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoGateway {

    Produto createProduto(Produto produto);

    List<Produto> findAllProdutos();

    Optional<Produto> getProdutoById(String id);
}
