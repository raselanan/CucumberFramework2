package com.test.StepDefinition;

import org.junit.Assert;
import com.test.PageObject.ExceptionsPage;
import com.test.Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExceptionsSteps {
    private ExceptionsPage exceptionsPage;

    @Given("User is on the exceptions page")
    public void user_is_on_the_exceptions_page() {
        exceptionsPage = new ExceptionsPage(BaseClass.driver);
        exceptionsPage.open();
    }

    @When("User adds a second row")
    public void user_adds_a_second_row() {
        exceptionsPage.addSecondRow();
    }

    @Then("The second row should be displayed")
    public void second_row_should_be_displayed() {
        Assert.assertTrue("Second row was not displayed", exceptionsPage.isSecondRowDisplayed());
    }

    @When("User changes the first row text to {string}")
    public void user_changes_the_first_row_text(String value) {
        exceptionsPage.editFirstRow(value);
    }

    @Then("The first row should contain {string}")
    public void first_row_should_contain(String expectedValue) {
        Assert.assertEquals(expectedValue, exceptionsPage.getFirstRowValue());
        Assert.assertTrue("Save confirmation was not displayed",
                exceptionsPage.getConfirmationMessage().toLowerCase().contains("saved"));
    }
}
