package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://localhost:5173/")
public class HomePage extends PageObject {

    public void login(String username, String password) {
        // Find the username and password input fields
        WebElementFacade usernameField = find(By.id("username"));
        WebElementFacade passwordField = find(By.id("password"));

        // Enter the username and password
        usernameField.type(username);
        passwordField.type(password);

        // Submit the login form
        WebElementFacade submitButton = find(By.className("button1"));
        submitButton.click();
    }

    public WebElementFacade getLoggedInUser() {
        return find(By.className("user-id"));
    }

    public boolean isLoginErrorDisplayed() {
        return find(By.className("MuiAlert-message")).isPresent();
    }
}