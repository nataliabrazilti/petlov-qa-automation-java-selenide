package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class Selenium {

	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void creatPoint() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://petlov.vercel.app/signup");

		WebElement title = driver.findElement(By.cssSelector("h1"));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> title.isDisplayed());

		assertEquals("Cadastro de ponto de doação", title.getText(), "Verificando o título da página de cadastro"
		);

		WebElement name =driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys("Natalia Brazil");

		WebElement email =driver.findElement(By.cssSelector("input[name='email']"));
		email.sendKeys("nataliabrazil@gmail.com");

		WebElement cep =driver.findElement(By.cssSelector("input[name='cep']"));
		cep.sendKeys("70636000");

		WebElement cepButton =driver.findElement(By.cssSelector("input[value='Buscar CEP']"));
		cepButton.click();

		WebElement number =driver.findElement(By.cssSelector("input[name=addressNumber]"));
		number.sendKeys("42");

		WebElement details =driver.findElement(By.cssSelector("input[name=addressDetails]"));
		details.sendKeys("Próximo ao parquinho colorido");

		driver.findElement(By.xpath("//span[text() = \"Gatos\"]/..")).click();

		driver.findElement(By.className("button-register")).click();

		WebElement result = driver.findElement(By.cssSelector("#success-page p"));

		Wait<WebDriver> waitResult = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitResult.until(d -> result.isDisplayed());

		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

		assertEquals(target, result.getText(), "Verificando a mensagem de sucesso do cadastro"
		);

		driver.close();
	}
}
