package com.test.PageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionsPage {
    private static final String URL = "https://practicetestautomation.com/practice-test-exceptions/";
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addButton = By.id("add_btn");
    private final By editButton = By.id("edit_btn");
    private final By firstRowInput = By.cssSelector("#row1 input");
    private final By secondRowInput = By.cssSelector("#row2 input");
    private final By saveButton = By.id("save_btn");
    private final By confirmation = By.id("confirmation");

    public ExceptionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() { driver.get(URL); }

    public void addSecondRow() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public boolean isSecondRowDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(secondRowInput)).isDisplayed();
    }

    public void editFirstRow(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        wait.until(webDriver -> {
            WebElement field = webDriver.findElement(firstRowInput);
            return field.getDomAttribute("disabled") == null
                    && field.getDomAttribute("readonly") == null;
        });
        WebElement input = driver.findElement(firstRowInput);
        input.clear();
        input.sendKeys(value);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public String getFirstRowValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowInput)).getAttribute("value");
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation)).getText();
    }
}
