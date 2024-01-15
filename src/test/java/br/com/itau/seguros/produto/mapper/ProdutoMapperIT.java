package br.com.itau.seguros.produto.mapper;

import br.com.itau.seguros.produto.infrastructure.gateway.ProdutoEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProduto;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProdutoMapperIT {

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Test
    void deveConverterProdutoParaProdutoEntity() {

        var produtoEntity = produtoEntityMapper.toProdutoEntity(createProduto());

        assertEquals("Seguro de Vida Individual", produtoEntity.nome());
        assertEquals(PATRIMONIAL, produtoEntity.categoria());
        assertEquals(new BigDecimal("100.00"), produtoEntity.precoBase());
    }

    @Test
    void deveConverterProdutoEntityParaProduto() {

        var produtoEntity = produtoEntityMapper.toProdutoEntity(createProduto());

        assertEquals("Seguro de Vida Individual", produtoEntity.nome());
        assertEquals(PATRIMONIAL, produtoEntity.categoria());
        assertEquals(new BigDecimal("100.00"), produtoEntity.precoBase());
    }
}
