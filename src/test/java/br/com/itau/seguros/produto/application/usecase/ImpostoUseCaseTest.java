package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.application.usecase.imposto.IofUseCase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static br.com.itau.seguros.produto.fixture.ImpostoFixture.createAliquotas;
import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImpostoUseCaseTest {

    @Test
    void deveCalcularOValorDoImpostoIof() {

        var imposto = new IofUseCase().calcularImposto(
                createAliquotas(),
                PATRIMONIAL,
                new BigDecimal("100.00"));

        assertEquals(new BigDecimal("5.00"), imposto);
    }

    @Test
    void deveRetornarZeroSeNaoEncontrarAliquota() {

        var imposto = new IofUseCase().calcularImposto(
                createAliquotas(),
                AUTO,
                new BigDecimal("100.00"));

        assertEquals(new BigDecimal("0"), imposto);
    }
}
