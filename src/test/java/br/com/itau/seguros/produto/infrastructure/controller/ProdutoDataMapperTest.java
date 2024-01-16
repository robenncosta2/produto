package br.com.itau.seguros.produto.infrastructure.controller;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProduto;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProdutoDataMapperTest {

    private final ProdutoDataMapper produtoDataMapper = new ProdutoDataMapper();

    @Test
    void deveConverterProdutoParaCreateProdutoResponse() {

        var produtoResponse = produtoDataMapper.toProdutoResponse(createProduto());

        assertNull(produtoResponse.id());
        assertEquals("Seguro de Vida Individual", produtoResponse.nome());
        assertEquals(PATRIMONIAL, produtoResponse.categoria());

        assertEquals(new BigDecimal("100.00"), produtoResponse.precoBase());
        assertEquals(new BigDecimal("110.00"), produtoResponse.precoTarifado());
    }

    @Test
    void deveConverterProdutosParaProdutosResponse() {

        var produtosResponse = produtoDataMapper.toListOfProdutos(createProdutos());

        assertNotNull(produtosResponse);
        assertEquals(2, produtosResponse.size());
    }

    @Test
    void deveConverterCreateProdutoRequestParaCreateProduto() {

    }
}
