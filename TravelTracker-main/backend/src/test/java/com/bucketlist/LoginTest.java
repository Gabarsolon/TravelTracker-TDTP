// package com.bucketlist;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import net.serenitybdd.junit.runners.SerenityRunner;
// import net.thucydides.core.annotations.Steps;
// import com.bucketlist.EndUserSteps;

// @RunWith(SerenityRunner.class)
// public class LoginTest {

//     @Steps
//     EndUserSteps endUser;

//     @Test
//     public void successfulLogin() {
//         endUser.is_the_login_page();
//         endUser.enters_username("your_username");
//         endUser.enters_password("your_password");
//         endUser.clicks_login_button();
//         endUser.should_be_redirected_to_dashboard();
//     }
// }