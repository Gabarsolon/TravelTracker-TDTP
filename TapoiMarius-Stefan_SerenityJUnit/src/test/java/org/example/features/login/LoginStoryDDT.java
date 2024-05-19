package org.example.features.login;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/TravelTrackerTestDataLogin.csv")
public class LoginStoryDDT {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String username;

    public String password;

    public String expectedResult;

    @Issue("#TravelTracker-1")
    @Test
    public void loginTestDDT() {
        user.is_the_home_page();
        user.logs_in(username, password);
        if ("success".equals(expectedResult)) {
            user.should_be_logged_in(username);
        } else {
            user.should_not_be_logged_in();
        }
    }
}
