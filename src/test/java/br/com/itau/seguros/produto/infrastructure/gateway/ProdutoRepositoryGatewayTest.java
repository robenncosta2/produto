package br.com.itau.seguros.produto.infrastructure.gateway;

import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProduto;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutoEntity;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutoEntityWithId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProdutoRepositoryGatewayTest {

    private ProdutoRepository produtoRepositoryMock;
    private ProdutoEntityMapper produtoEntityMapperMock;

    private ProdutoRepositoryGateway produtoRepositoryGateway;

    @BeforeEach
    void setUp() {
        produtoRepositoryMock = mock(ProdutoRepository.class);
        produtoEntityMapperMock = mock(ProdutoEntityMapper.class);

        produtoRepositoryGateway = new ProdutoRepositoryGateway(
            produtoRepositoryMock,
            produtoEntityMapperMock
        );
    }

    @Test
    void deveRetornarProdutoAoReceberProduto() {

        var produto = produtoRepositoryGateway.createProduto(createProduto());

        when(produtoRepositoryMock.save(createProdutoEntity()))
            .thenReturn(createProdutoEntityWithId());

        when(produtoEntityMapperMock.toProdutoEntity(createProduto()))
                .thenReturn(createProdutoEntity());

        assertEquals("Seguro de Vida Individual", produto.nome());
        assertEquals(PATRIMONIAL, produto.categoria());

        assertEquals(new BigDecimal("100.00"), produto.precoBase());
        assertEquals(new BigDecimal("106.00"), produto.precoTarifado());
    }
}
