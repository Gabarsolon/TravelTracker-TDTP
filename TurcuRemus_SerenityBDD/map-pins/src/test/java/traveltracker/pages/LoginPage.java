package traveltracker.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("http://localhost:5173/")
public class LoginPage extends PageObject {
    @FindBy(id = "username")
    private WebElementFacade usernameInputField;

    @FindBy(id = "password")
    private WebElementFacade passwordInputField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/button")
    private WebElementFacade loginButton;

    public void enter_username(String username){
        usernameInputField.type(username);
    }

    public void enter_password(String password){
        passwordInputField.type(password);
    }

    public void perform_login(){
        loginButton.click();
    }

}
