package br.com.itau.seguros.produto.infrastructure.gateway;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoRepository;
import br.com.itau.seguros.produto.domain.model.Produto;

import java.util.List;
import java.util.Optional;

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
        var produtoSaved = produtoRepository.save(produtoEntity);

        return produtoEntityMapper.toProduto(produtoSaved);
    }

    @Override
    public List<Produto> findAllProdutos() {

        var produtos = produtoRepository.findAll();
        return produtoEntityMapper.toProdutos(produtos);
    }

    @Override
    public Optional<Produto> getProdutoById(String id) {

        var produtoEntity = produtoRepository.findById(id);

        return produtoEntityMapper.toProdutoOptional(produtoEntity);
    }
}
