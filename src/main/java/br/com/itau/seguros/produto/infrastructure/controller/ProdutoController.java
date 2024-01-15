package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.application.usecase.CriarProdutoInteractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);

    private final CriarProdutoInteractor criarProdutoInteractor;
    private final ProdutoRequestResponseMapper produtoRequestResponseMapper;

    public ProdutoController(CriarProdutoInteractor criarProdutoInteractor, ProdutoRequestResponseMapper produtoRequestResponseMapper) {
        this.criarProdutoInteractor = criarProdutoInteractor;
        this.produtoRequestResponseMapper = produtoRequestResponseMapper;
    }

    @PostMapping
    public ResponseEntity<CreateProdutoResponse> createProduto(@Validated @RequestBody CreateProdutoRequest createProdutoRequest) {

        LOG.info("Criando produto, produtoRequest = {}", createProdutoRequest);

        var produtoBusiness = produtoRequestResponseMapper.toCreateProduto(createProdutoRequest);
        var produto = criarProdutoInteractor.createProduto(produtoBusiness);

        return ok(produtoRequestResponseMapper.toCreateProdutoResponse(produto));
    }
}
