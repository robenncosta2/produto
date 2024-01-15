package br.com.itau.seguros.produto.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {}
