package br.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursoMap {
    @FindBy(xpath = "//*[@id=\"block-214\"]/div/div/div/div[2]/p[1]/span")
    public WebElement h2Titulo;
}
