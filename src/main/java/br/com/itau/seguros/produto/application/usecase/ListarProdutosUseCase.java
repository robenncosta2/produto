package br.com.itau.seguros.produto.application.usecase;

import br.com.itau.seguros.produto.domain.model.Produto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListarProdutosUseCase {

    List<Produto> findAllProdutos();
}
