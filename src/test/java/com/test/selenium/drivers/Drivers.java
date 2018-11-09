package com.test.selenium.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public enum Drivers implements DriverSetup {

    FIREFOX {
        @Override
        public RemoteWebDriver getWebDriver(DesiredCapabilities capabilities) {
            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            options.setHeadless(HEADLESS);

            if (capabilities.getPlatform().name().contains("win")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/webDrivers/firefox/windows/geckodriver.exe");

                String browserPath = System.getProperty("browser.binary.firefox.path");
                if (null != browserPath && !browserPath.isEmpty()) {
                    options.setBinary(browserPath);
                }
            }
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

    public final static boolean HEADLESS = System.getProperty("headless").equals("yes");
    //public static final String os = System.getProperty("os.name");
}
