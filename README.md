# Rendimento de Clientes

[![License](http://img.shields.io/badge/license-MIT-green.svg?style=flat)](https://github.com/vandersozc/Bankslip/blob/master/LICENCA)
[![Build Status](https://travis-ci.com/vandersozc/Bankslip.svg?branch=master)](https://travis-ci.com/vandersozc/Bankslip)
[![SonarQube Coverage](https://img.shields.io/sonar/http/sonar.petalslink.com/org.ow2.petals%3Apetals-se-ase/coverage.svg)](https://sonarcloud.io/dashboard?id=com.vandersoncamp%3Abankslip%3Amaster)

-------
<p align="center">
    <a href="#projeto">Projeto</a> &bull;
	<a href="#instalação-e-utilizacao">Instalação</a> &bull;
	<a href="#testes-e-cobertura">Testes e Cobertura</a> &bull;
	<a href="#build-e-análise">Build e Análise do código</a> &bull;
	<a href="#endpoints">Serviços disponíneis</a> &bull;
	<a href="#licença">Licença</a>
</p>
-------

## Projeto

Serviço de API Rest para cálculo de rendimento de clientes. Pode ser consumido por um módulo de um sistema, onde é possível cadastrar um cliente e seus endereços, calcular o rendimento de um cliente e pesquisar os rendimentos.


## Instalação e Utilização

Back-end:
Este projeto utiliza [Maven](https://maven.apache.org/), para build da aplicação e gerenciamento das dependências. Foi construído utilizando a stack do [WildFly Swarm](http://wildfly-swarm.io/). Efetuar o download do projeto e executar o build através da linha de comando na pasta raiz do projeto ou pela IDE de desenvolvimento:
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
- O build remoto do projeto pode ser visualizado com: [Travis CI](https://travis-ci.com/vandersozc/Bankslip).
- A análise de código pode ser visualizada com: [SonarCLoud](https://sonarcloud.io/dashboard?id=com.vandersoncamp%3Abankslip%3Amaster).

## Serviços
EndPoints disponíneis para utilização do serviço.


## Licença
Este projeto está licenciado sob os termos da licença do MIT. Veja o arquivo [LICENÇA](https://github.com/vandersozc/Bankslip/blob/master/LICENCA).