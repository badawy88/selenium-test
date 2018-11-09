package com.test.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static WebDriver driver;
    private static String browserName = System.getProperty("browser.name");
    private static String baseURL = System.getProperty("base.url");
    private static boolean headless;
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    private DriverFactory() {

    }


    protected static WebDriver getDriver() {
        driver = Drivers.valueOf(browserName.toUpperCase()).getWebDriver(desiredCapabilities);
        driver.get(baseURL);

        return driver;
    }

    public static WebDriver getCurrentDriver() {
        return driver;
    }
}
