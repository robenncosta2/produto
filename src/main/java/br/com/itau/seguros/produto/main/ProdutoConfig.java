package br.com.itau.seguros.produto.main;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.application.usecase.CriarProdutoInteractor;
import br.com.itau.seguros.produto.application.usecase.CriarProdutoInteractorImpl;
import br.com.itau.seguros.produto.application.usecase.imposto.CofinsInteractor;
import br.com.itau.seguros.produto.application.usecase.imposto.ImpostoInteractor;
import br.com.itau.seguros.produto.application.usecase.imposto.IofInteractor;
import br.com.itau.seguros.produto.application.usecase.imposto.PisInteractor;
import br.com.itau.seguros.produto.application.usecase.preco.CalculadorDePrecoInteractor;
import br.com.itau.seguros.produto.application.usecase.preco.CalculadorDePrecoInteractorImpl;
import br.com.itau.seguros.produto.infrastructure.controller.ProdutoRequestResponseMapper;
import br.com.itau.seguros.produto.infrastructure.gateway.ProdutoEntityMapper;
import br.com.itau.seguros.produto.infrastructure.gateway.ProdutoRepositoryGateway;
import br.com.itau.seguros.produto.infrastructure.persistence.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProdutoConfig {

    @Bean
    CriarProdutoInteractor createProdutoInteractor(ProdutoGateway produtoGateway, CalculadorDePrecoInteractor calculadorDePrecoInteractor) {
        return new CriarProdutoInteractorImpl(produtoGateway, calculadorDePrecoInteractor);
    }

    @Bean
    ProdutoGateway produtoGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
    }

    @Bean
    ProdutoEntityMapper produtoEntityMapper() {
        return new ProdutoEntityMapper();
    }

    @Bean
    ProdutoRequestResponseMapper produtoRequestResponseMapper() {
        return new ProdutoRequestResponseMapper();
    }

    @Bean
    CalculadorDePrecoInteractor calculadorDePrecoInteractor(Set<ImpostoInteractor> impostos) {

        var impostosImpl = new HashSet<ImpostoInteractor>();

        impostosImpl.add(new IofInteractor());
        impostosImpl.add(new PisInteractor());
        impostosImpl.add(new CofinsInteractor());

        return new CalculadorDePrecoInteractorImpl(impostosImpl);
    }
}
