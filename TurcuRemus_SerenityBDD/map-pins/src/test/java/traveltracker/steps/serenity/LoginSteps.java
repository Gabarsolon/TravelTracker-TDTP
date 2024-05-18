package traveltracker.steps.serenity;

import net.thucydides.core.annotations.Step;
import traveltracker.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;
    @Step
    public void opens_login_page(){
        loginPage.open();
    }
    @Step
    public void enters_username(String username){
        loginPage.enter_username(username);
    }
    @Step
    public void enters_password(String password){
        loginPage.enter_password(password);
    }
    @Step
    public void performs_login(){
        loginPage.perform_login();
    }
}