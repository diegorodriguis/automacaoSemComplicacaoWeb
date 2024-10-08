package br.chronosacademy.steps;

import br.chronosacademy.core.Driver;
import br.chronosacademy.pages.LoginPage;
import br.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class NewAccountSteps {

    NewAccountPage newAccountPage;
    String userName;

    @Dado("que a pagina new account esteja sendo exibida")
    public void queAPaginaNewAccountEstejaSendoExibida() {
        newAccountPage = new NewAccountPage();
        Driver.getDriver().get("https://www.advantageonlineshopping.com/#/");
        Driver.getDriver().get("https://www.advantageonlineshopping.com/#/register");
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
    }

    @Quando("os campos de cadastros estiverem preenchidos com")
    public void osCamposDeCadastrosEstiveremPreenchidosCom(Map<String, String> map) {
        userName = map.get("username");
        newAccountPage.setInpUserName(map.get("username"));
        newAccountPage.setInpEmail(map.get("email"));
        newAccountPage.setInpPassword(map.get("password"));
        newAccountPage.setInpConfirmPassword(map.get("password"));
        newAccountPage.selectCountry(map.get("country"));
        newAccountPage.clickBtnIagree();
        newAccountPage.clickBtnRegister();
    }

    @Entao("deve ser possivel logar no sistema apos o cadastro")
    public void deveSerPossivelLogarNoSistemaAposOCadastro() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(userName, loginPage.getTextUsuarioLogado());
    }

}
