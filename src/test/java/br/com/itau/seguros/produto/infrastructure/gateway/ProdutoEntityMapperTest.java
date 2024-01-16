package br.com.itau.seguros.produto.infrastructure.gateway;

import br.com.itau.seguros.produto.fixture.ProdutoFixture;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProduto;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutoEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProdutoEntityMapperTest {

    private final ProdutoEntityMapper produtoEntityMapper = new ProdutoEntityMapper();

    @Test
    void deveConverterProdutoParaProdutoEntitySemId() {

        var produto = createProduto();
        var produtoEntity = produtoEntityMapper.toProdutoEntity(produto);

        assertNull(produtoEntity.id());
        assertEquals("Seguro de Vida Individual", produtoEntity.nome());
        assertEquals(PATRIMONIAL, produtoEntity.categoria());

        assertEquals(new BigDecimal("100.00"), produtoEntity.precoBase());
        assertEquals(new BigDecimal("110.00"), produtoEntity.precoTarifado());
    }

    @Test
    void deveConverterProdutoEntityParaProduto() {

        var produtoEntity = createProdutoEntity();
        var produto = produtoEntityMapper.toProduto(produtoEntity);

        assertNull(produto.id());
        assertEquals("Seguro de Vida Individual", produto.nome());
        assertEquals(VIDA, produto.categoria());

        assertEquals(new BigDecimal("100.00"), produto.precoBase());
        assertEquals(new BigDecimal("106.00"), produto.precoTarifado());
    }

    @Test
    void deveConverterProdutosEntityParaProdutos() {

        var produtosEntity = ProdutoFixture.createProdutosEntity();
        var produtos = produtoEntityMapper.toProdutos(produtosEntity);

        assertNotNull(produtos);
        assertEquals(2, produtos.size());
    }
}
