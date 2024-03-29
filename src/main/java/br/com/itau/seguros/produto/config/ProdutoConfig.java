package br.com.itau.seguros.produto.config;

import br.com.itau.seguros.produto.application.gateway.ProdutoGateway;
import br.com.itau.seguros.produto.application.usecase.BuscarProdutoUseCaseImpl;
import br.com.itau.seguros.produto.application.usecase.CriarProdutoUseCase;
import br.com.itau.seguros.produto.application.usecase.CriarProdutoUseCaseImpl;
import br.com.itau.seguros.produto.application.usecase.ListarProdutoUseCaseImpl;
import br.com.itau.seguros.produto.application.usecase.ListarProdutosUseCase;
import br.com.itau.seguros.produto.application.usecase.imposto.CofinsUseCase;
import br.com.itau.seguros.produto.application.usecase.imposto.ImpostoUseCase;
import br.com.itau.seguros.produto.application.usecase.imposto.IofUseCase;
import br.com.itau.seguros.produto.application.usecase.imposto.PisUseCase;
import br.com.itau.seguros.produto.application.usecase.preco.CalculadorDePrecoInteractor;
import br.com.itau.seguros.produto.application.usecase.preco.CalculadorDePrecoInteractorImpl;
import br.com.itau.seguros.produto.infrastructure.controller.ProdutoDataMapper;
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
    CriarProdutoUseCase createProdutoInteractor(ProdutoGateway produtoGateway, CalculadorDePrecoInteractor calculadorDePrecoInteractor) {
        return new CriarProdutoUseCaseImpl(produtoGateway, calculadorDePrecoInteractor);
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
    ProdutoDataMapper produtoRequestResponseMapper() {
        return new ProdutoDataMapper();
    }

    @Bean
    ListarProdutosUseCase listarProdutosUseCase(ProdutoGateway produtoGateway) {
        return new ListarProdutoUseCaseImpl(produtoGateway);
    }

    @Bean
    BuscarProdutoUseCaseImpl buscarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new BuscarProdutoUseCaseImpl(produtoGateway);
    }

    @Bean
    CalculadorDePrecoInteractor calculadorDePrecoInteractor(Set<ImpostoUseCase> impostos) {

        var impostosImpl = new HashSet<ImpostoUseCase>();

        impostosImpl.add(new IofUseCase());
        impostosImpl.add(new PisUseCase());
        impostosImpl.add(new CofinsUseCase());

        return new CalculadorDePrecoInteractorImpl(impostosImpl);
    }
}
