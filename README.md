![Capa do projeto Petlov QA Automation](.github/cover.png)

# Petlov QA Automation

Projeto de portfólio com testes automatizados de interface para o fluxo de cadastro de pontos de doação da plataforma [Petlov](https://petlov.vercel.app/signup).

Os testes foram desenvolvidos em Java e exploram duas abordagens de automação: Selenium WebDriver e Selenide, com validações usando JUnit 5.

## Cenário coberto

- Acessar a página de cadastro e validar o título.
- Preencher os dados do ponto de doação e consultar o CEP.
- Selecionar a categoria de animais.
- Enviar o formulário e validar a mensagem de sucesso.

## Tecnologias

- Java 21
- JUnit Jupiter 5.10.2
- Selenium WebDriver 4.20.0
- Selenide 7.19.0
- Maven

## Pré-requisitos

- JDK 21
- Maven instalado e disponível no terminal
- Google Chrome instalado

## Como executar

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/nataliabrazilti/petlov-qa-automation.git
cd petlov-qa-automation
```

Execute os testes:

```bash
mvn -Dtest=Cadastro,Selenium test
```

## Créditos

Projeto desenvolvido como prática de automação de testes durante o treinamento da [RocketSkills](https://rocketskills.com.br/).
