# Desafio de Programação Tunts

![GitHub](https://img.shields.io/github/license/AnaBilecki/desafio-tunts?style=for-the-badge)

Este projeto é uma aplicação backend em Java para geração de um arquivo XLSX a partir das informações obtidas no consumo da API [REST Countries](https://restcountries.com/#api-endpoints-v3-all).
Ao rodar a aplicação, o objetivo é gerar uma planilha com o conteúdo conforme apresentado na seção [Estrutura](#estrutura).

O projeto foi desenvolvido para a etapa de desafio de programação do processo seletivo da Tunts.Rocks para a vaga de Estágio (Dev Training Program).

## Tabela de Conteúdos

   * [Sobre](#desafio-de-programação-tunts)
   * [Estrutura](#estrutura)
   * [Tecnologias utilizadas](#tecnologias-utilizadas)
   * [Ferramentas utilizadas](#ferramentas-utilizadas)
   * [Dependências utilizadas](#dependências-utilizadas)
   * [Como executar o projeto](#como-executar-o-projeto)
     * [Pré-requisitos](#pré-requisitos)
     * [Execução](#execução)
   * [Autora](#autora)

## Estrutura
![image](https://user-images.githubusercontent.com/84636509/186991466-41f515dc-19a1-42f8-a1db-d1e981b71def.png)

## Tecnologias utilizadas

As seguintes tecnologias foram utilizadas na construção do projeto:

   * Java
   * Maven

## Ferramentas utilizadas

As seguintes ferramentas foram utilizadas na construção do projeto:

   * [JDK](https://www.oracle.com/java/technologies/downloads/) | Versão 11.0.11

## Dependências utilizadas

| Nome                                                                               |                                          Descrição                                          |
| -------------------------------------------------------------------------------------------- | :-----------------------------------------------------------------------------------------: |
| [gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)                                               |           Biblioteca do Google utilizada na conversão de objetos Java em representação JSON                        |
| [apache.poi](https://mvnrepository.com/artifact/org.apache.poi/poi)                                               |        Framework que possibilita a leitura e escrita de dados em documentos do Microsoft Office                          |

## Como executar o projeto

### Pré-requisitos

Para que seja possível executar o projeto, é necessário que em sua máquina estejam instalados:

   * [Git](https://git-scm.com/)
   * JDK
   * Maven

### Execução

1. Clone este repositório:
```bash
$ git clone https://github.com/AnaBilecki/desafio-tunts
```
2. Acesse a pasta do projeto.
3. Execute a limpeza e gere o pacote do projeto:
```bash
mvn clean package
```
4. Rode a aplicação:
```bash
mvn exec:java -Dexec.mainClass="com.desafio_tunts.application.Program"
```
## Autora

**Ana Carolina Bilecki** 

<a href="https://github.com/AnaBilecki">
  <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" />
</a>

<a href="https://linkedin.com/in/ana-carolina-bilecki">
  <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>
