package br.com.itau.seguros.produto.application.usecase.preco;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;

@SpringBootTest
public class CalculadorDePrecoInteractorImplIT {

    @Autowired
    private CalculadorDePrecoInteractorImpl calculadorDePrecoInteractorImpl;

    @Test
    void deveCalcularOPrecoTarifadoDeUmProdutoParaCategoriaVida() {

        var precoTarifado = calculadorDePrecoInteractorImpl.calcularPrecoTarifado(
                new BigDecimal("100.00"),
                VIDA);

        assertEquals(new BigDecimal("103.20"), precoTarifado);
    }
}
