package br.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {


    @FindBy(css = "[id='menuUser']")
    public WebElement btnLogin;
    @FindBy(css = "[class='closeBtn loginPopUpCloseBtn']")
    public WebElement btnFechar;
    @FindBy(css = "[class='PopUp']")
    public WebElement divFechaModal;
    @FindBy(css = "*[name='username']")
    public WebElement inpUserName;
    @FindBy(css = "*[name='password']")
    public WebElement inpPassword;
    @FindBy(css = "#sign_in_btn")
    public WebElement btnSignIn;
    @FindBy(css = "*[name='remember_me']")
    public WebElement inpRemember;
    @FindBy(linkText = "CREATE NEW ACCOUNT")
    public WebElement linkCreateAccount;
    @FindBy(css = "[class='loader']")
    public WebElement divLoader;

}
