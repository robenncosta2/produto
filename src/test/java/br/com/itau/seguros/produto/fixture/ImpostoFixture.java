package br.com.itau.seguros.produto.fixture;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;
import java.util.Map;

import static java.math.BigDecimal.valueOf;
import static java.util.Map.of;

import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.RESIDENCIAL;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;

public class ImpostoFixture {

    private ImpostoFixture() {}

    static public Map<Categoria, BigDecimal> createAliquotas() {
        return of(
            VIDA, valueOf(1),
            VIAGEM, valueOf(2),
            RESIDENCIAL, valueOf(4 ),
            PATRIMONIAL, valueOf(5 )
        );
    }
}
