package br.chronosacademy.pages;

import br.chronosacademy.core.Driver;
import br.chronosacademy.maps.NewAccountMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
    NewAccountMap newAccountMap;

    public NewAccountPage(){
        newAccountMap = new NewAccountMap();
        PageFactory.initElements(Driver.getDriver(), newAccountMap);
    }

    public String getTextNewAccount(){
        Driver.visibilityOf(newAccountMap.txtCreateAccount);
        return newAccountMap.txtCreateAccount.getText();
    }

    public void setInpUserName(String name){
        newAccountMap.inpUserName.sendKeys(name);
    }
    public void setInpEmail(String email){
        newAccountMap.inpEmail.sendKeys(email);
    }
    public void setInpPassword(String password){
        newAccountMap.inpPassword.sendKeys(password);
    }
    public void setInpConfirmPassword(String password){
        newAccountMap.inpConfirmPassword.sendKeys(password);
    }
    public void selectCountry(String country){
        Select select = new Select(newAccountMap.slcCountry);
        Driver.aguardaOptions(select);
        select.selectByVisibleText(country);
    }
    public void clickBtnIagree(){
        newAccountMap.inpIagree.click();
    }
    public void clickBtnRegister(){
        newAccountMap.btnRegister.click();
    }

}
