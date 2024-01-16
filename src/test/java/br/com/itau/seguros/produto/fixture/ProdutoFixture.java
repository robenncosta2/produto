package br.com.itau.seguros.produto.fixture;

import br.com.itau.seguros.produto.domain.model.Produto;
import br.com.itau.seguros.produto.infrastructure.controller.CreateProdutoRequest;
import br.com.itau.seguros.produto.infrastructure.controller.ProdutoResponse;
import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static java.util.List.*;

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

    public static ProdutoResponse createProdutoResponse() {

        return new ProdutoResponse(
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

    public static ProdutoEntity createProdutoEntity() {

        return new ProdutoEntity(
            null,
            "Seguro de Vida Individual",
            VIDA,
            new BigDecimal("100.00"),
            new BigDecimal("106.00")
        );
    }

    public static ProdutoEntity createProdutoEntityWithId() {

        return new ProdutoEntity(
            "c7bf920a-45c6-4848-aac6-059940802813",
            "Seguro de Vida Individual",
            VIDA,
            new BigDecimal("100.00"),
            new BigDecimal("106.00")
        );
    }

    public static List<ProdutoEntity> createProdutosEntity() {
        return of(createProdutoEntity(), createProdutoEntity());
    }
}
