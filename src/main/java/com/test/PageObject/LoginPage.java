package com.test.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    LoginPage loginPage;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("submit");
    By logoutBtn = By.xpath("//a[text()='Log out']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean logoutButtonIsDisplayed() {
        return driver.findElement(logoutBtn).isDisplayed();
    }

    public void loginWithInvalidUsername(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        // driver.findElement(By.id("submit")).click();
        driver.findElement(loginBtn).click();
    }

   public boolean isErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        return error.isDisplayed();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error"))).getText();
    }


}
