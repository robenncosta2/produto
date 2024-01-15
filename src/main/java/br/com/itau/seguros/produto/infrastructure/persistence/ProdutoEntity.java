package br.com.itau.seguros.produto.infrastructure.persistence;

import br.com.itau.seguros.produto.domain.model.Categoria;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record ProdutoEntity(

    @Id
    String id,
    String nome,
    Categoria categoria,
    BigDecimal precoBase,
    BigDecimal precoTarifado
) {}
