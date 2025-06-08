package com.test.StepDefinition;

import com.test.PageObject.LoginPage;
import com.test.Utilities.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver = BaseClass.driver;
    LoginPage loginPage;

    @Given("User is on login page")
    public void user_on_login_page() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void enter_credentials() {
        loginPage.login("student", "Password123");
    }

    @Then("User should be logged in successfully")
    public void verify_login() {
        // 1. URL check
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL does not contain 'logged-in-successfully'",
                currentUrl.contains("logged-in-successfully"));

        // 2. Page message check
        String pageSource = driver.getPageSource().toLowerCase();
        Assert.assertTrue("Missing success message",
                pageSource.contains("congratulations") || pageSource.contains("successfully logged in"));

        // 3. Logout button check
        Assert.assertTrue("Logout button not displayed", loginPage.logoutButtonIsDisplayed());
    }

    @When("User enters invalid username")
    public void enter_invalid_username() {
        loginPage.loginWithInvalidUsername("incorrectUser", "Password123");
    }

    @Then("An error message {string} should be displayed")
    public void verify_error_message(String expectedMessage) {
        // Assert.assertTrue("Error message not displayed",
        // loginPage.isErrorDisplayed());
        // Assert.assertEquals("Wrong error message", expectedMessage,
        // loginPage.getErrorMessage());

        Assert.assertTrue("Error message not displayed", loginPage.isErrorDisplayed());
        Assert.assertEquals("Wrong error message", expectedMessage, loginPage.getErrorMessage());
        System.out.println("Page Source:\n" + driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Your username is invalid!"));

    }

}
