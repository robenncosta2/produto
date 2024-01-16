package br.com.itau.seguros.produto.application.usecase.imposto;

import org.junit.jupiter.api.Test;

import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.RESIDENCIAL;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CofinsUseCaseTest {

    @Test
    void deveRetornarOsValoresDasAliquotasDoImpostoCofins() {

        var aliquotas = new CofinsUseCase().getAliquotas();

        assertNotNull(aliquotas);

        assertEquals(valueOf(1), aliquotas.get(AUTO));
        assertEquals(valueOf(1), aliquotas.get(VIAGEM));
        assertEquals(valueOf(3), aliquotas.get(RESIDENCIAL));
    }
}
