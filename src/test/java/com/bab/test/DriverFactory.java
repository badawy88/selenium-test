package com.bab.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static String browserName = System.getProperty("browser.name");
    private static String baseURL = System.getProperty("base.url");
    private static boolean headless;

    public static WebDriver driver;

    private  static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    static {
        driver = Drivers.valueOf(browserName.toUpperCase()).getWebDriver(desiredCapabilities);
        driver.get(baseURL);
    }

    private DriverFactory() {

    }
}
