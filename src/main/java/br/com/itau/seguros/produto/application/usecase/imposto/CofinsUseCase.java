package br.com.itau.seguros.produto.application.usecase.imposto;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;
import java.util.Map;

import static br.com.itau.seguros.produto.domain.model.Categoria.AUTO;
import static br.com.itau.seguros.produto.domain.model.Categoria.VIAGEM;
import static br.com.itau.seguros.produto.domain.model.Categoria.RESIDENCIAL;
import static java.math.BigDecimal.valueOf;
import static java.util.Map.of;

public class CofinsUseCase implements ImpostoUseCase {

    @Override
    public Map<Categoria, BigDecimal> getAliquotas() {
        return of(
            AUTO, valueOf(1),
            VIAGEM, valueOf(1),
            RESIDENCIAL, valueOf(3)
        );
    }
}
