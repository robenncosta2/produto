package br.com.itau.seguros.produto.fixture;

import br.com.itau.seguros.produto.domain.model.Produto;
import br.com.itau.seguros.produto.infrastructure.controller.CreateProdutoRequest;
import br.com.itau.seguros.produto.infrastructure.controller.CreateProdutoResponse;

import java.math.BigDecimal;

import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;

public class ProdutoFixture {

    private ProdutoFixture() {}

    public static CreateProdutoRequest createProdutoRequest() {

        return new CreateProdutoRequest(
            "Seguro de Vida Individual",
            PATRIMONIAL,
            new BigDecimal("100.00")
        );
    }

    public static CreateProdutoRequest createProdutoSemNomeRequest() {

        return new CreateProdutoRequest(
            null,
            VIDA,
            new BigDecimal("100.00")
        );
    }

    public static CreateProdutoRequest createProdutoSemCategoriaRequest() {

        return new CreateProdutoRequest(
            "Seguro de Vida Individual",
            null,
            new BigDecimal("100.00")
        );
    }

    public static CreateProdutoRequest createProdutoSemPrecoBaseRequest() {

        return new CreateProdutoRequest(
            "Seguro de Vida Individual",
            PATRIMONIAL,
            null
        );
    }

    public static CreateProdutoResponse createProdutoResponse() {

        return new CreateProdutoResponse(
            "c7bf920a-45c6-4848-aac6-059940802813",
            "Seguro Auto",
            AUTO,
            new BigDecimal("100.00"),
            new BigDecimal("106.00")
        );
    }

    public static Produto createProduto() {

        return new Produto(
            null,
            "Seguro de Vida Individual",
            PATRIMONIAL,
            new BigDecimal("100.00"),
            new BigDecimal("110.00")
        );
    }
}
