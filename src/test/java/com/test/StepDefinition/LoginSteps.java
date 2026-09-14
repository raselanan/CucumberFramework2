package com.test.StepDefinition;

import org.junit.Assert;
import com.test.PageObject.LoggedInPage;
import com.test.PageObject.LoginPage;
import com.test.Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("User is on login page")
    public void user_on_login_page() {
        loginPage = new LoginPage(BaseClass.driver);
        loginPage.open();
    }

    @When("User enters valid credentials")
    public void enter_credentials() {
        loginPage.login("student", "Password123");
    }

    @When("User enters username {string} and password {string}")
    public void enter_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should be logged in successfully")
    public void verify_login() {
        LoggedInPage loggedInPage = new LoggedInPage(BaseClass.driver);
        Assert.assertTrue("Logged-in page was not loaded", loggedInPage.isLoaded());
        Assert.assertTrue("Logout button not displayed", loggedInPage.isLogoutButtonDisplayed());
    }

    @When("User enters invalid username")
    public void enter_invalid_username() {
        loginPage.login("incorrectUser", "Password123");
    }

    @When("User enters an invalid password")
    public void enter_invalid_password() {
        loginPage.login("student", "incorrectPassword");
    }

    @Then("An error message {string} should be displayed")
    public void verify_error_message(String expectedMessage) {
        Assert.assertTrue("Error message not displayed", loginPage.isErrorDisplayed());
        Assert.assertEquals("Wrong error message", expectedMessage, loginPage.getErrorMessage());
    }
}
