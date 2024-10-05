package br.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountMap {
    @FindBy(css = "[class='roboto-regular sticky fixedImportant ng-scope']")
    public WebElement txtCreateAccount;
    @FindBy(name = "usernameRegisterPage")
    public WebElement inpUserName;
    @FindBy(name = "emailRegisterPage")
    public WebElement inpEmail;
    @FindBy(name = "passwordRegisterPage")
    public WebElement inpPassword;
    @FindBy(name = "confirm_passwordRegisterPage")
    public WebElement inpConfirmPassword;
    @FindBy(name = "countryListboxRegisterPage")
    public WebElement slcCountry;
    @FindBy(name = "i_agree")
    public WebElement inpIagree;
    @FindBy(id = "register_btn")
    public WebElement btnRegister;

}
