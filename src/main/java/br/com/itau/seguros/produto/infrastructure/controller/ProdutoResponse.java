package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.domain.model.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProdutoResponse(

    String id,
    String nome,
    Categoria categoria,

    @JsonProperty("preco_base")
    BigDecimal precoBase,

    @JsonProperty("preco_tarifado")
    BigDecimal precoTarifado
) {}
