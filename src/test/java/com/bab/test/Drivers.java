package com.bab.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.ArrayList;

public enum Drivers implements DriverSetup{

    FIREFOX {
        @Override
        public RemoteWebDriver getWebDriver(DesiredCapabilities capabilities) {
            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            options.setHeadless(HEADLESS);

            return new FirefoxDriver(options);
        }
    },
    CHROME {
        @Override
        public RemoteWebDriver getWebDriver(DesiredCapabilities capabilities) {
            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);
            return new ChromeDriver(options);
        }
    },
    SAFARI {
        @Override
        public RemoteWebDriver getWebDriver(DesiredCapabilities capabilities) {
            SafariOptions options = new SafariOptions();
            options.merge(capabilities);
            return new SafariDriver(options);
        }
    };

    public final static boolean HEADLESS = System.getProperty("headless").equals("yes") ? true : false;
}
