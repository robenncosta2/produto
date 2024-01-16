package br.com.itau.seguros.produto.application.usecase.imposto;

import org.junit.jupiter.api.Test;

import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PisImpostoUseCaseTest {

    @Test
    void deveRetornarOsValoresDasAliquotasDoImpostoPis() {

        var aliquotas = new PisUseCase().getAliquotas();

        assertNotNull(aliquotas);

        assertEquals(valueOf(2.2), aliquotas.get(VIDA));
        assertEquals(valueOf(4), aliquotas.get(AUTO));
        assertEquals(valueOf(4), aliquotas.get(VIAGEM));
        assertEquals(valueOf(3), aliquotas.get(PATRIMONIAL));
    }
}
