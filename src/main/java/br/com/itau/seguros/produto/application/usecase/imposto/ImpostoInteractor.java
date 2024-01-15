package br.com.itau.seguros.produto.application.usecase.imposto;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;
import java.util.Map;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.DOWN;
import static java.util.Objects.nonNull;

public interface ImpostoInteractor {

    Map<Categoria, BigDecimal> getAliquotas();

    default BigDecimal calcularImposto(Map<Categoria, BigDecimal> aliquotas, Categoria categoria, BigDecimal precoBase) {

        var aliquota = aliquotas.get(categoria);

        if (nonNull(aliquota)) {
            var percentual = aliquota.setScale(6, DOWN).divide(valueOf(100), DOWN);
            return precoBase.multiply(percentual).setScale(2, DOWN);
        }

        return ZERO;
    }
}
