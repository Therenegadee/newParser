package com.researchser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TagAttrParser implements TwoParametersParserInterface {

    private final WebDriver driver;

    public TagAttrParser (WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String parseByParameters(String url, String tagName, String attributeName) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement tagElement = driver.findElement(By.tagName(tagName));
        String elementValue = tagElement.getAttribute(attributeName);
        driver.quit();
        return elementValue;
    }
}
