package com.researchser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CSSSelectorParser implements SearchElementParserStrategy {

    private final WebDriver driver;

    public CSSSelectorParser(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String parseByParameters(String url, String cssSelector, String parameter2) {
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement element = driver.findElement(By.cssSelector(cssSelector));
            String elementValue = element.getText();
            driver.quit();
            return elementValue;
    }
}
