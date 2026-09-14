package com.test.PageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage {
    private final WebDriverWait wait;
    private final By heading = By.tagName("h1");
    private final By logoutButton = By.linkText("Log out");

    public LoggedInPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoaded() {
        wait.until(ExpectedConditions.urlContains("logged-in-successfully"));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heading))
                .getText().toLowerCase().contains("logged in successfully");
    }

    public boolean isLogoutButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
    }
}
