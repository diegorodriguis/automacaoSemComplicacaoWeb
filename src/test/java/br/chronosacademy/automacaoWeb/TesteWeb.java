package br.chronosacademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TesteWeb {
    ChromeDriver driver;

    @BeforeEach
    public void inicializaTeste() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.chronosacademy.com.br");
    }

    @Test
    public void primeiroTeste() {
        String xpathTitulo = "//section[2]/div[3]/div/div/div[1]/div/h4";
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String tituloCapturado = txtTitulo.getText();
        assertEquals(tituloCapturado, "Porque Tempo É Conhecimento.");


    }
    @AfterEach
    public void finalizaTeste() {
        driver.quit();
    }
}
