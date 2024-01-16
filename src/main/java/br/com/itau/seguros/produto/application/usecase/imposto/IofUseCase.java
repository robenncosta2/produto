package br.com.itau.seguros.produto.application.usecase.imposto;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;
import java.util.Map;

import static br.com.itau.seguros.produto.domain.model.Categoria.VIDA;
import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.RESIDENCIAL;
import static br.com.itau.seguros.produto.domain.model.Categoria.PATRIMONIAL;

import static java.math.BigDecimal.valueOf;
import static java.util.Map.of;

public class IofUseCase implements ImpostoUseCase {

    @Override
    public Map<Categoria, BigDecimal> getAliquotas() {
        return of(
            VIDA, valueOf(1),
            AUTO, valueOf(5.5),
            VIAGEM, valueOf(2),
            RESIDENCIAL, valueOf(4),
            PATRIMONIAL, valueOf(5)
        );
    }
}
