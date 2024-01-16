package br.com.itau.seguros.produto.application.usecase.imposto;

import org.junit.jupiter.api.Test;

import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.RESIDENCIAL;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IofInteractorTest {

    @Test
    void deveRetornarOsValoresDasAliquotasDoImpostoIof() {

        var aliquotas = new IofUseCase().getAliquotas();

        assertNotNull(aliquotas);

        assertEquals(valueOf(1), aliquotas.get(VIDA));
        assertEquals(valueOf(5.5), aliquotas.get(AUTO));
        assertEquals(valueOf(2), aliquotas.get(VIAGEM));
        assertEquals(valueOf(4), aliquotas.get(RESIDENCIAL));
        assertEquals(valueOf(5), aliquotas.get(PATRIMONIAL));
    }
}
