package br.com.rocketskills.petlov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


class Cadastro {

	@Test 
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void creatPoint() {

		open("https://petlov.vercel.app/signup");
		$("h1").shouldHave(text("Cadastro de ponto de doação"));

		$("input[placeholder= 'Nome do ponto de doação']").setValue("Estação Pet");
		$("input[name=email]").setValue("estacaopet@gmail.com");
		$("input[name=cep]").setValue("70636000");
		$("input[value='Buscar CEP']").click();
		$("input[name=addressNumber]").setValue("1000");
		$("input[name=addressDetails]").setValue("Próximo ao parquinho colorido");
		$(By.xpath("//span[text()=\"Gatos\"]/..")).click();
		$(".button-register").click();

		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

		$("#success-page p").shouldHave(text(target));
	}
}
