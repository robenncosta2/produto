package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.domain.model.Categoria;

import java.math.BigDecimal;

public record CreateProdutoResponse(
    String id,
    String nome,
    Categoria categoria,
    BigDecimal precoBase,
    BigDecimal precoTarifado
) {}
