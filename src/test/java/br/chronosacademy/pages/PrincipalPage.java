package br.chronosacademy.pages;

import br.chronosacademy.maps.CursoMap;
import br.chronosacademy.maps.PrincipalMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrincipalPage {
    private WebDriver driver;
    private PrincipalMap principalMaps;


    public PrincipalPage(WebDriver driver) {
        this.driver = driver;
        principalMaps = new PrincipalMap();
        PageFactory.initElements(driver, principalMaps);
    }
    public String getTitulo() {
        return principalMaps.txtTitulo.getText();
    }
    public void clickBotao() {
        principalMaps.btnTitulo.click();
    }
}
