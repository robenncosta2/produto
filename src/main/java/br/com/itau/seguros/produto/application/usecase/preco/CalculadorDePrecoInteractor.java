package br.com.itau.seguros.produto.application.usecase.preco;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;

public interface CalculadorDePrecoInteractor {

    BigDecimal calcularPrecoTarifado(BigDecimal precoBase, Categoria categoria);
}
