package br.com.itau.seguros.produto.application.usecase.imposto;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;
import java.util.Map;

import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;

import static java.math.BigDecimal.valueOf;
import static java.util.Map.of;

public class PisUseCase implements ImpostoUseCase {

    @Override
    public Map<Categoria, BigDecimal> getAliquotas() {
        return of(
            VIDA, valueOf(2.2),
            AUTO, valueOf(4),
            VIAGEM, valueOf(4),
            PATRIMONIAL, valueOf(3)
        );
    }
}
