package br.com.itau.seguros.produto.application.usecase.preco;

import br.com.itau.seguros.produto.application.usecase.imposto.ImpostoUseCase;
import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;
import java.util.Set;

import static java.math.BigDecimal.ZERO;

public class CalculadorDePrecoInteractorImpl implements CalculadorDePrecoInteractor {

    private final Set<ImpostoUseCase> impostos;

    public CalculadorDePrecoInteractorImpl(Set<ImpostoUseCase> impostos) {
        this.impostos = impostos;
    }

    @Override
    public BigDecimal calcularPrecoTarifado(BigDecimal precoBase, Categoria categoria) {

        return impostos
            .stream()
            .map(imposto -> imposto.calcularImposto(imposto.getAliquotas(), categoria, precoBase))
            .reduce(ZERO, BigDecimal::add)
            .add(precoBase);
    }
}
