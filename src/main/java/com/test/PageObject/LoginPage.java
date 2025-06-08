package com.test.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.className("btn");
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
    //driver.findElement(By.id("submit")).click();
    driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("error")).getText(); // adjust selector if needed
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(By.id("error")).isDisplayed(); // adjust selector if needed
    }


}
