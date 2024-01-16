# Produto de Seguros API

## Stack

* Java 17
* Spring Boot 3.1
* MongoDB

## Pré-Requisitos

Para executar o projeto é necessário possuir as ferramentas abaixo instaladas no seu ambiente de desenvolvimento:
* Git 
* Docker
* Docker Compose (docker-compose)
* Maven _(com o comando mvn diponível via linha de comando)_

## Como Executar?

* Entre na pasta raíz do projeto via linha de comando e execute:

`docker-compose up -d`

`mvn spring-boot:run`

## Documentação

A API foi documentada usando o Swagger. Para testar os endpoints após subir o projeto acesse a url abaixo:
`http://localhost:9000/swagger-ui/index.html#/`

## Racional com Relação a Solução 

### Patterns & SOLID

Como premissa não é necessário armazenar os impostos em base de dados ou arquivos de configuração.
Dessa forma escolhi uma abordagem com o uso do **Design Pattern Strategy**, 
mantendo as alíquotas de impostos no próprio código da aplicação. 

Caso seja necessário adicionar um novo imposto, podemos implemantar a **interface** Imposto
e seguir o contrato estabelecido, não sendo necessário mecher em outros arquivos, respeitando o príncipio
**SOLID** *Open Close Principal*

### Testes

* Testes de unidade (cobertura mínima de 90%)
* Testes de integração para cenários específicos (controladores, conversores, classes de persistência de dados)

### Arquitetura

A arquivotura escolhira para este projeto foi a **_Clean Architecture_** 
_(Arquitetura Limpa)_.
Algumas vantagens dessa arquitetura:
* Melhor separação entre código de negócio e infraestrutura (frameworks, libs)
* Código mais fácil de testar por guiar o desenvolvedor no uso de melhores práticas de desenvolvimento

### Por que MongoDB?

Com base no exemplo de retorno da API presente na documentação, pude observar que a chave id trata-se de uma
chave única universal (UUID), nesse sentido optei por utilizar um banco de dados que Oferecesse esse suporte
de forma nativa.

## Outros Endpoins

Para que a API ficasse mais completa, adicionei mais 2 endpoins do tipo GET, um para busca geral
e outro para busca pelo id.
