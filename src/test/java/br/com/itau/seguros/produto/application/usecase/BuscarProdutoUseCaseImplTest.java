package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.infrastructure.gateway.ProdutoRepositoryGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProduto;
import static java.util.Optional.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BuscarProdutoUseCaseImplTest {

    private ProdutoRepositoryGateway produtoRepositoryGatewayMock;
    private BuscarProdutoUseCaseImpl buscarProdutoUseCaseImpl;

    @BeforeEach
    void setUp() {
        produtoRepositoryGatewayMock = mock(ProdutoRepositoryGateway.class);
        buscarProdutoUseCaseImpl = new BuscarProdutoUseCaseImpl(
            produtoRepositoryGatewayMock
        );
    }

    @Test
    void deveRetornarUmProduto() {

        when(produtoRepositoryGatewayMock.getProdutoById("65a5ceda8f4ac1245e1299d5"))
            .thenReturn(of(createProduto()));

        var produto = buscarProdutoUseCaseImpl.getProdutoById("65a5ceda8f4ac1245e1299d5");
    }
}
