package br.com.rocketskills.petlov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



class PontoDoacao{
	String nome;
	String email;
	String cep;		
	Integer numero;
	String complemento;
	String pets;

	public PontoDoacao(String nome, String email, String cep, Integer numero, String complemento, String pets) {
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.pets = pets; 
	}
}

class Cadastro {

	@Test 
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void creatPoint() {

		// Pre-condição 
		PontoDoacao ponto = new PontoDoacao(
			"Estação Pet",
			"estacaopet@gmail.com",
			"70636000",
			1000,
			"Próximo ao parquinho colorido",
			"Gatos"
		);

		open("https://petlov.vercel.app/signup");
		$("h1").shouldHave(text("Cadastro de ponto de doação"));

		// Ação
		$("input[placeholder= 'Nome do ponto de doação']").setValue(ponto.nome);
		$("input[name=email]").setValue(ponto.email);
		$("input[name=cep]").setValue(ponto.cep);
		$("input[value='Buscar CEP']").click();
		$("input[name=addressNumber]").setValue(ponto.numero.toString());
		$("input[name=addressDetails]").setValue(ponto.complemento);
		$(By.xpath("//span[text()=\"" + ponto.pets + "\"]/..")).click();
		$(".button-register").click();

		// Validação
		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
		$("#success-page p").shouldHave(text(target));
	}
}
