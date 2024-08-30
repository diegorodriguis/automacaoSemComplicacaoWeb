package br.chronosacademy.automacaoWeb;

import br.chronosacademy.core.Driver;
import br.chronosacademy.enums.Browser;
import br.chronosacademy.pages.CursoPage;
import br.chronosacademy.pages.PrincipalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TesteWeb {
    Driver driverWeb;
    WebDriver driver;
    PrincipalPage principalPage;
    CursoPage cursoPage;
    @BeforeEach
    public void inicializaTeste() {
        driverWeb = new Driver(Browser.CHROME);
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);

    }

    @Test
    public void primeiroTeste() {
        String titulo = principalPage.getTitulo();
        assertEquals("Porque Tempo É Conhecimento.", titulo);
    }
    @Test
    public void segundoTeste() throws InterruptedException {
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();
        String titulo = cursoPage.getTitulo2();
        Thread.sleep(5000);

        assertEquals("Cursos de excelente qualidade, criados pensando em você!", titulo);
    }




    @AfterEach
    public void finalizaTeste() {
        driver.quit();
    }
}
