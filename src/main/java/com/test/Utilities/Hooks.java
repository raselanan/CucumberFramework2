// Hooks.java
package com.test.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {
    // this is hooks file
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless"); // optional for CI/CD

        BaseClass.driver = new ChromeDriver(options);
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BaseClass.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (BaseClass.driver != null) {
            BaseClass.driver.quit();
        }
    }
}
