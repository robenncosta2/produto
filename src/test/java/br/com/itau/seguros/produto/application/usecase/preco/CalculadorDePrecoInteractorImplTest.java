package br.com.itau.seguros.produto.application.usecase.preco;

import br.com.itau.seguros.produto.application.usecase.imposto.CofinsInteractor;
import br.com.itau.seguros.produto.application.usecase.imposto.ImpostoInteractor;
import br.com.itau.seguros.produto.application.usecase.imposto.IofInteractor;
import br.com.itau.seguros.produto.application.usecase.imposto.PisInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static br.com.itau.seguros.produto.fixture.ImpostoFixture.createAliquotas;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadorDePrecoInteractorImplTest {

    private IofInteractor iofImpostoInteractorMock;
    private PisInteractor pisImpostoInteractorMock;
    private CofinsInteractor cofinsInteractorMock;
    private CalculadorDePrecoInteractorImpl calculadorDePrecoInteractorImpl;

    @BeforeEach
    void setUp() {

        Set<ImpostoInteractor> impostosMock = new HashSet<>();
        calculadorDePrecoInteractorImpl = new CalculadorDePrecoInteractorImpl(impostosMock);

        iofImpostoInteractorMock = mock(IofInteractor.class);
        pisImpostoInteractorMock = mock(PisInteractor.class);
        cofinsInteractorMock = mock(CofinsInteractor.class);

        impostosMock.addAll(of(
            iofImpostoInteractorMock,
            pisImpostoInteractorMock,
            cofinsInteractorMock)
        );
    }

    @Test
    void deveRetornarOPrecoTarifadoParaCategoriaVida() {

        var precoBase = new BigDecimal("100.00");
        var aliquotas = createAliquotas();

        when(iofImpostoInteractorMock.getAliquotas())
            .thenReturn(aliquotas);

        when(pisImpostoInteractorMock.getAliquotas())
            .thenReturn(aliquotas);

        when(cofinsInteractorMock.getAliquotas())
            .thenReturn(aliquotas);

        when(iofImpostoInteractorMock.calcularImposto(aliquotas, VIDA, precoBase))
            .thenReturn(new BigDecimal("10.00"));

        when(pisImpostoInteractorMock.calcularImposto(aliquotas, VIDA, precoBase))
            .thenReturn(new BigDecimal("5.00"));

        when(cofinsInteractorMock.calcularImposto(aliquotas, VIDA, precoBase))
            .thenReturn(new BigDecimal("2.00"));

        var precoTarifado = calculadorDePrecoInteractorImpl.calcularPrecoTarifado(precoBase, VIDA);

        assertEquals(new BigDecimal("117.00"), precoTarifado);
    }
}
