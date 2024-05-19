package org.example.steps.serenity;

import org.example.pages.HomePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class EndUserSteps {

    HomePage homePage;


    @Step
    public void is_the_home_page() {
        homePage.open();
    }

    @Step
    public void logs_in(String username, String password) {
        homePage.login(username, password);
    }

    @Step
    public void should_be_logged_in(String username) {
        assertThat(homePage.getLoggedInUser().getText(), containsString(username));
    }

    @Step
    public void should_not_be_logged_in() {
        assertThat(homePage.isLoginErrorDisplayed(), is(true));
    }
}