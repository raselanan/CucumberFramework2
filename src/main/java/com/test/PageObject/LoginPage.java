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

}
