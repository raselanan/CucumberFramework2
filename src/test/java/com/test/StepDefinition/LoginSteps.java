package com.test.StepDefinition;

import com.test.PageObject.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on login page")
    public void user_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void enter_credentials() {
        loginPage.login("testuser", "testpass");
    }

    @Then("User should be logged in successfully")
    public void verify_login() {
        System.out.println("Login Successful");
        driver.quit();
    }
}
