package br.chronosacademy.steps;

import br.chronosacademy.core.Driver;
import br.chronosacademy.enums.Browser;
import br.chronosacademy.pages.LoginPage;
import br.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;

    @Before
    public void iniciarNavegador(){
        new Driver(Browser.CHROME);
    }
    @After
    public void fecharNavegador(){
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clicarBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
    }

    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.clicarDivFechaModal();
    }

    @Entao("a modal deve ser fechada")
    public void aModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        }catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }
    }

    @Quando("for realizado um clique no icone")
    public void forRealizadoUmCliqueNoIcone() {
        loginPage.clicarBtnFechar();
    }

    @Quando("for realizado um clique no link Create new account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clicarLinkCreateAccount();
    }

    @Entao("deve ser direcionado para tela de criacao de conta")
    public void deveSerDirecionadoParaTelaDeCriacaoDeConta() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());

    }

    @Quando("os campos de login sejam preechidos da seguinte forma")
    public void osCamposDeLoginSejamPreechidosDaSeguinteForma(Map<String, String> map) {
        String userName = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(userName);
        loginPage.setInpPassword(password);

        if (remember){
            loginPage.clicarImpRemember();
        }
    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clicarBtnSignIn();

    }

    @Entao("deve ser logado no sistema")
    public void deveSerLogadoNoSistema() {
    }

    @Entao("sistema deve exibir uma mensagem de erro")
    public void sistemaDeveExibirUmaMensagemDeErro() {
    }


    @Entao("o botao sign in deve ficar desabilitado")
    public void oBotaoSignInDeveFicarDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
    }
}
