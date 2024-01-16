package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.infrastructure.gateway.ProdutoRepositoryGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListarProdutoUseCaseImplTest {

    private ProdutoRepositoryGateway produtoRepositoryGatewayMock;
    private ListarProdutoUseCaseImpl listarProdutoUseCaseImpl;

    @BeforeEach
    void setUp() {
        produtoRepositoryGatewayMock = mock(ProdutoRepositoryGateway.class);
        listarProdutoUseCaseImpl = new ListarProdutoUseCaseImpl(produtoRepositoryGatewayMock);
    }

    @Test
    void deveRetornarUmaListaComDoisProdutos() {

        when(produtoRepositoryGatewayMock.findAllProdutos())
            .thenReturn(createProdutos());

        var produtos = listarProdutoUseCaseImpl.findAllProdutos();

        assertNotNull(produtos);
        assertEquals(2, produtos.size());
    }
}
