# Rendimento de Clientes

[![License](http://img.shields.io/badge/license-MIT-green.svg?style=flat)](https://github.com/vandersozc/rendimento_cliente/blob/master/LICENCA)
[![Build Status](https://travis-ci.com/vandersozc/rendimento_cliente.svg?branch=master)](https://travis-ci.com/vandersozc/rendimento_cliente)
[![SonarQube Coverage](https://img.shields.io/sonar/http/sonar.petalslink.com/org.ow2.petals%3Apetals-se-ase/coverage.svg)](https://sonarcloud.io/dashboard?id=com.vandersoncamp%3Arendimento%3Amaster)

-------
<p align="center">
    <a href="#projeto">Projeto</a> &bull;
	<a href="#instalação">Instalação e Utilização</a> &bull;
	<a href="#testes-e-cobertura">Testes e Cobertura</a> &bull;
	<a href="#build-e-análise">Build e Análise do código</a> &bull;
	<a href="#serviços">Serviços disponíneis</a> &bull;
	<a href="#licença">Licença</a>
</p>
-------

## Projeto

Serviço de API Rest para cálculo de rendimento de clientes. Pode ser consumido por um módulo de um sistema, onde é possível cadastrar um cliente e seus endereços, calcular o rendimento de um cliente e pesquisar os rendimentos.


## Instalação

Back-end:
Este projeto utiliza [Maven](https://maven.apache.org/), para build da aplicação e gerenciamento das dependências. Foi construído utilizando a stack do [WildFly Swarm](http://wildfly-swarm.io/). Para a persistência dos dados foi utilizado o banco H2, pelo fato de ser executado em memória e não necessita de configuração por parte do usuário. Efetuar o download do projeto e executar o build através da linha de comando na pasta raiz do projeto ou pela IDE de desenvolvimento:
```
mvn clean wildfly-swarm:run
```

Front-end:
Utiliza páginas [HTML](https://www.w3schools.com/html/html5_intro.asp/) e [Bootstrap](https://getbootstrap.com/) na versão 4 como framework para a criação de layouts. Para estilo dos layouts foi utilizado [Css](https://www.w3schools.com/Css/). Para os eventos das páginas foi utilizado [AngularJS](https://angularjs.org/) 
na versão 1.6 e [Jquery](https://jquery.com/). Como linguagem de programação front-end foi utilizado [JavaScript](https://www.javascript.com/).

Após inicializar o servidor com wildfy-swarm é possível visualizar a página em: 
```
http://localhost:8080/#!/clientes
```

## Testes e Cobertura

Este projeto utiliza [JUnit 5](https://junit.org/junit5/) para testes unitários e de integração. Você pode executar os testes a qualquer momento. Tudo o que você precisa fazer é executar a linha de comando na pasta raiz do projeto ou pela IDE de desenvolvimento:
```
mvn clean test
```

## Build e Análise
- O build remoto do projeto pode ser visualizado com: [Travis CI](https://travis-ci.com/vandersozc/rendimento_cliente).
- A análise de código pode ser visualizada com: [SonarCLoud](https://sonarcloud.io/dashboard?id=com.vandersoncamp%3Arendimento%3Amaster).

## Serviços
Serviços disponíneis para utilização na aplicação.

Criar cliente:
@POST: http://localhost:8080/api/clientes
```
{  
   "enderecos":[  
      {  
         "logradouro":"Rua 001",
         "numero":"123",
         "bairro":"Bairro 001",
         "cidade":"Cidade 001",
         "estado":"Estado 001",
         "complemento":"Complemento"
      }
   ],
   "nome":"Pedro",
   "rendimentoMensal":900.22,
   "risco":"C"
}
```
Lista de Clientes:
@GET: http://localhost:8080/api/clientes

Consulta por Cliente:
@GET: http://localhost:8080/api/clientes/{id}

Atualizar um Cliente:
@PUT: http://localhost:8080/api/clientes/{id}
```
{  
   "enderecos":[  
      {  
         "logradouro":"Rua 002",
         "numero":"1234",
         "bairro":"Bairro 002",
         "cidade":"Cidade 002",
         "estado":"Estado 002",
         "complemento":"Complemento 2"
      }
   ],
   "id":1,
   "nome":"Maria",
   "rendimentoMensal":800.00,
   "risco":"C"
}
```
Remover um Cliente:
@DELETE: http://localhost:8080/api/clientes/{id}

Simular Empréstimo do Cliente:
@PUT: http://localhost:8080/api/clientes/simular-emprestimo
```
{  
   "cliente":{  
      "id":1,
      "nome":"Pedro",
      "rendimentoMensal":900.22,
      "risco":"C",
      "enderecos":[  
         {  
            "id":1,
            "logradouro":"Rua 002",
            "numero":1234,
            "bairro":"Bairro 002",
            "cidade":"Cidade 002",
            "estado":"Estado 002",
            "complemento":"Complemento 2"
         }
      ]
   },
   "valorSolicitado":1200,
   "valorSimulacao":null,
   "meses":12
}
```

## Licença
Este projeto está licenciado sob os termos da licença do MIT. Veja o arquivo [LICENÇA](https://github.com/vandersozc/rendimento_cliente/blob/master/LICENCA).