# Produto de Seguros API

## Stack

* Java 17
* Spring Boot 3.1
* MongoDB

## Pré-Requisitos

Será necessário ter as ferramentas abaixo instaladas no seu ambiente de desenvolvimento:
* Git 
* Docker
* Docker Compose (docker-compose)
* Maven _(com o comando mvn diponível via linha de comando)_

## Como Executar?

* Entre na pasta raíz do projeto via linha de comando e execute:

`mvn spring-boot:run`

`docker-compose up -d`

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

Optei por fazer uma separação entre camadas (infraestrutra, aplicação e domínio), utilizando como arquitetura a **_Clean Architecture_** 
_(Arquitetura Limpa)_.
É uma arquitetura mais recente e com isso traz alguns benefícios:
* Melhor separação entre código de negócio e infraestrutura (frameworks, libs)
