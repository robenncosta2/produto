package br.com.itau.seguros.produto.domain.model;

import java.math.BigDecimal;

public record Produto(
    String id,
    String nome,
    Categoria categoria,
    BigDecimal precoBase,
    BigDecimal precoTarifado
 ) {}
