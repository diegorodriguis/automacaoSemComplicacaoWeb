package br.chronosacademy.steps;

import br.chronosacademy.core.Driver;
import br.chronosacademy.enums.Browser;
import br.chronosacademy.pages.LoginPage;
import br.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    String userName;

    @Before
    public void iniciarNavegador(Scenario scenario){
        new Driver(Browser.CHROME);
        Driver.setNameScenario(scenario.getName());
        Driver.creatDirectory();
    }
    @After
    public void fecharNavegador(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            Driver.printScreen("Error - Momento que houve a falha no cenario");
        }
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
    public void osCamposDeLoginSejamPreechidosDaSeguinteForma(Map<String, String> map) throws IOException {
        userName = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(userName);
        loginPage.setInpPassword(password);

        if (remember){
            loginPage.clicarImpRemember();
        }
        Driver.printScreen("Preenchimento dos campos de login");
    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clicarBtnSignIn();

    }

    @Entao("deve ser logado no sistema")
    public void deveSerLogadoNoSistema() throws IOException {
        Assert.assertEquals(userName, loginPage.getTextUsuarioLogado());
        Driver.printScreen("Tela de usuario logado no sistema");
    }

    @Entao("sistema deve exibir uma mensagem de erro")
    public void sistemaDeveExibirUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect user name or password.", loginPage.getTextErroLogin());
    }

    @Entao("o botao sign in deve ficar desabilitado")
    public void oBotaoSignInDeveFicarDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
    }
}
