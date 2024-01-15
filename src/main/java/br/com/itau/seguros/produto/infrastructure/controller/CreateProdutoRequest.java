package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.domain.model.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProdutoRequest(

    @NotEmpty
    String nome,

    @NotNull
    Categoria categoria,

    @JsonProperty("preco_base")
    @NotNull
    BigDecimal precoBase
) {}
