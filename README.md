# Produto de Seguros API

## Pré-Requisitos para Executar o Projeto?

Para executar o projeto é necessário ter as ferramentas abaixo instaladas em seu
ambiente de desenvolvimento:
* Git 
* Docker
* Docker Compose

## Como Executar o Projeto?

* Entre na pasta raíz do projeto e execute o comando:

`docker-compose up -d`

## Racional com Relação a Solução 

### Patterns & SOLID

Não sendo necessário armazenar os impostos em base de dados ou arquivos de configuração
optei por uma abordagem com o uso do **Design Pattern Strategy**, mantendo as alíquotas no próprio código
da aplicação. 

Dessa forma caso seja necessário adicionar um novo imposto, bastaria implemantar a **interface** Imposto
e seguir o contrato estabelecido, não sendo necessário mecher em outros arquivos. Dessa forma respeitando o príncipio
**SOLID** *Open Close Principal*

### Testes & Qualidade 

O objeto foi atingir uma cobetura de testes de unidade próxima a 100%.
Também foram realizados testes de integração, arquivos nomeados com sufixo IT (convensão)

### Arquitetura

Optei por fazer uma separação entre camadas de infraestrutra, aplicação e domínio utilizando a **_Clean Architecture_** 
(Arquitetura Limpa).
Uma das vantagens dessa arquitetura é poder facilmente transportar todo código para um novo framework se necessário e
com poucas ajustes.
