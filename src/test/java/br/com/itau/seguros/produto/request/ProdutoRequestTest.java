package br.com.itau.seguros.produto.request;

import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutoSemCategoriaRequest;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutoSemNomeRequest;
import static br.com.itau.seguros.produto.fixture.ProdutoFixture.createProdutoSemPrecoBaseRequest;
import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProdutoRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        var factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveVerificarSeONomeDoProdutoSeraExigido() {

        var produtoRequest = createProdutoSemNomeRequest();
        var violations = validator.validate(produtoRequest);

        assertFalse(violations.isEmpty());
    }

    @Test
    void deveVerificarSeACategoriaDoProdutoSeraObrigatoria() {

        var produtoRequest = createProdutoSemCategoriaRequest();
        var violations = validator.validate(produtoRequest);

        assertFalse(violations.isEmpty());
    }

    @Test
    void deveVerificarSeOPrecoBaseDoProdutoSeraObrigatorio() {

        var produtoRequest = createProdutoSemPrecoBaseRequest();
        var violations = validator.validate(produtoRequest);

        assertFalse(violations.isEmpty());
    }
}
