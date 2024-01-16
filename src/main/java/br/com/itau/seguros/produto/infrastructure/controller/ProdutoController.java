package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.application.usecase.BuscarProdutoUseCase;
import br.com.itau.seguros.produto.application.usecase.CriarProdutoUseCase;
import br.com.itau.seguros.produto.application.usecase.ListarProdutosUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);

    private final CriarProdutoUseCase criarProdutoUseCase;
    private final ListarProdutosUseCase listarProdutosUseCase;
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final ProdutoDataMapper produtoDataMapper;

    public ProdutoController(CriarProdutoUseCase criarProdutoUseCase,
                             ListarProdutosUseCase listarProdutosUseCase,
                             BuscarProdutoUseCase buscarProdutoUseCase, ProdutoDataMapper produtoDataMapper) {

        this.criarProdutoUseCase = criarProdutoUseCase;
        this.listarProdutosUseCase = listarProdutosUseCase;
        this.buscarProdutoUseCase = buscarProdutoUseCase;
        this.produtoDataMapper = produtoDataMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAllProdutos() {

        LOG.info("Listando produtos...");

        var produtos = listarProdutosUseCase.findAllProdutos();
        return ok(produtoDataMapper.toListOfProdutos(produtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getProdutoById(@PathVariable("id") String id) {

        LOG.info("Recuperando produto com base no id, id = {}", id);

        var produtoOptional = buscarProdutoUseCase.getProdutoById(id);

        return produtoOptional
                .map(produto -> ok(produtoDataMapper.toProdutoResponse(produto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> createProduto(@Validated @RequestBody CreateProdutoRequest createProdutoRequest) {

        LOG.info("Criando produto, produtoRequest = {}", createProdutoRequest);

        var produtoBusiness = produtoDataMapper.toCreateProduto(createProdutoRequest);
        var produto = criarProdutoUseCase.createProduto(produtoBusiness);

        return ok(produtoDataMapper.toProdutoResponse(produto));
    }

    @PutMapping
    public ResponseEntity<ProdutoResponse> updateProduto(@Validated @RequestBody CreateProdutoRequest createProdutoRequest,
            @PathVariable("id") String id) {

        LOG.info("Atualizando produto, produtoRequest = {}", createProdutoRequest);

        var produtoBusiness = produtoDataMapper.toCreateProduto(createProdutoRequest);
        var produto = criarProdutoUseCase.createProduto(produtoBusiness);

        return ok(produtoDataMapper.toProdutoResponse(produto));
    }
}
