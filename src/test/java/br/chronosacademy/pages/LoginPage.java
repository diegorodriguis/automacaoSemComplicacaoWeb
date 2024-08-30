package br.chronosacademy.pages;

import br.chronosacademy.core.Driver;
import br.chronosacademy.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }
    public void clicarBtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }
    public void clicarBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);
        loginMap.btnFechar.click();
    }
    public void clicarDivFechaModal(){
        loginMap.divFechaModal.click();
    }
    public void setInpUserName(String userName) {
        if (userName != null) {
            loginMap.inpUserName.sendKeys(userName);
        }
    }
    public void setInpPassword(String password){
        if(password != null) {
            loginMap.inpPassword.sendKeys(password);
        }
    }
    public void clicarImpRemember(){
        loginMap.inpRemember.click();
    }
    public void clicarLinkCreateAccount(){
        loginMap.linkCreateAccount.click();
    }
    public void clicarBtnSignIn(){
        loginMap.btnSignIn.click();
    }
    public boolean isBtnSignIn(){
        return loginMap.btnSignIn.isEnabled();
    }

    public  void visibilityOfBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);
    }
    public  void invisibilityOfBtnFechar(){
        Driver.invisibilityOf(loginMap.btnFechar);
    }
    public  void aguardaLoader(){
        Driver.attributChange(loginMap.divLoader, "display", "none");
    }
    public  String getTextUsuarioLogado(){
        Driver.visibilityOf(loginMap.textLogado);
        return loginMap.textLogado.getText();
    }
    public  String getTextErroLogin(){
        Driver.visibilityOf(loginMap.textErroLogin);
        return loginMap.textErroLogin.getText();
    }

}
