package br.com.itau.seguros.produto.infrastructure.gateway;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoRepository;
import br.com.itau.seguros.produto.domain.model.Produto;

public class ProdutoRepositoryGateway implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    public ProdutoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoEntityMapper = produtoEntityMapper;
    }

    @Override
    public Produto createProduto(Produto produto) {

        var produtoEntity = produtoEntityMapper.toProdutoEntity(produto);

        return produtoEntityMapper.toProduto(
            produtoRepository.save(produtoEntity)
        );
    }
}
