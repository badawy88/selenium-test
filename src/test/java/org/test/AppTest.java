package org.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest
{
    WebDriver driver;
    @Before
    public void setUp() {
       driver = new SafariDriver();
       driver.get("https://www.wikipedia.org");
    }

    @Test
    public void main () throws InterruptedException {

//        WebDriverWait wait2 = new WebDriverWait(driver, 10);

        WebElement link;
        link = driver.findElement(By.partialLinkText("English"));
        link.click();

        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Software developer");
        wait2 = new WebDriverWait(driver, 20);
        Thread.sleep(4000);

        WebElement submit = driver.findElement(By.name("go"));
        submit.click();
        wait2 = new WebDriverWait(driver, 20);
        Thread.sleep(4000);
        driver.quit();

    }
}
