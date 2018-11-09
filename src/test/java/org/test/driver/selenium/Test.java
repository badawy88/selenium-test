package org.test.driver.selenium;

import com.test.selenium.drivers.BaseTestCase;
import org.openqa.selenium.By;

public class Test extends BaseTestCase {
    @org.junit.Test
    public void testScenario() {
        driver.findElement(By.className(""));
        $(".element").sendKeys("");
    }
}
