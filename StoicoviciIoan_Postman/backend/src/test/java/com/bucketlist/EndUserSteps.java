// package com.bucketlist;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import net.thucydides.core.annotations.Step;
// import net.serenitybdd.core.steps.ScenarioSteps;

// public class EndUserSteps extends ScenarioSteps {

//     WebDriver driver;

//     @Step
//     public void is_the_login_page() {
//         driver.get("http://localhost:5173");
//     }

//     @Step
//     public void enters_username(String username) {
//         driver.findElement(By.name("username")).sendKeys(username);
//     }

//     @Step
//     public void enters_password(String password) {
//         driver.findElement(By.name("password")).sendKeys(password);
//     }

//     @Step
//     public void clicks_login_button() {
//         driver.findElement(By.id("button1")).click();
//     }

//     @Step
//     public void should_be_redirected_to_dashboard() {
//         // Implement assertion to check if the user is redirected to the dashboard page
//         // Example: assertTrue(driver.getCurrentUrl().contains("dashboard"));
//     }
// }