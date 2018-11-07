package com.bab.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestCase {
    protected static WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = DriverFactory.driver;

        $("#j_username").sendKeys("username");
        Thread.sleep(1000);

        $("#j_password").sendKeys("password");
        Thread.sleep(1000);

        $("#loginBtn").click();
        Thread.sleep(4000);
    }

    @After
    public void finish() {
        driver.quit();
    }

    /**
     *
     * @param selector
     * @return
     */
    public static WebElement $(final String selector) {
        String element = selector.substring(1, selector.length());
        if (selector.startsWith("#")) {
            return driver.findElement(By.id(element));
        } else if (selector.startsWith(".")) {
            return driver.findElement(By.className(element));
        } else if (selector.startsWith("")) {
            return driver.findElement(By.cssSelector(""));
        }
        return null;
    }

}
