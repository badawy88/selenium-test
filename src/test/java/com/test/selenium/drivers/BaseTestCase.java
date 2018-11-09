package com.test.selenium.drivers;

import com.test.selenium.drivers.rule.TestWatcherRule;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTestCase {
    protected static WebDriver driver;

    @Rule
    public TestWatcherRule testWatcher = new TestWatcherRule();

    /**
     * @param selector #id or .name or xpath element
     * @return web element based on the selector type or null if the element is not found
     */
    protected static WebElement $(final String selector) {
        String element = selector.substring(1);
        char selectorCharacter = selector.charAt(0);

        switch (selectorCharacter) {
            case '#':
                return driver.findElement(By.id(element));
            case '.':
                return driver.findElement(By.className(element));
            default:
                return driver.findElement(By.xpath(selector));
        }
    }

    @Before
    public void setUp() throws InterruptedException {
        driver = DriverFactory.getDriver();

        $("#j_username").sendKeys("username");
        Thread.sleep(1000);

        $("#j_password").sendKeys("password");
        Thread.sleep(1000);

        $("#loginBtn").click();
        Thread.sleep(4000);
    }

}
