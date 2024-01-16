package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.application.usecase.BuscarProdutoUseCase;
import br.com.itau.seguros.produto.application.usecase.CriarProdutoUseCase;
import br.com.itau.seguros.produto.application.usecase.ListarProdutosUseCase;
import br.com.itau.seguros.produto.domain.model.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
    public ResponseEntity<List<ProdutoResponse>> findAllProdutos(Pageable pageable) {

        LOG.info("Listando produtos, pageable = {}", pageable);

        var produtos = listarProdutosUseCase.findAllProdutos();
        return ok(produtoDataMapper.toListOfProdutos(produtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getProdutoById(String id) throws NotFoundException {

        LOG.info("Recuperando produto com base no id, id = {}", id);

        var produto = buscarProdutoUseCase.getProdutoById(id);

        return ok(produtoDataMapper.toProdutoResponse(
            produto.orElseThrow(NotFoundException::new))
        );
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
            @RequestAttribute String id) {

        LOG.info("Atualizando produto, produtoRequest = {}", createProdutoRequest);

        var produtoBusiness = produtoDataMapper.toCreateProduto(createProdutoRequest);
        var produto = criarProdutoUseCase.createProduto(produtoBusiness);

        return ok(produtoDataMapper.toProdutoResponse(produto));
    }
}
