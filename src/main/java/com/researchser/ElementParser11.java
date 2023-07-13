package com.researchser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ElementParser11 {

    public String parseElementByXpath (WebDriver driver, String url, String xPath) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(By.xpath(xPath));
        String elementValue = element.getText();
        System.out.println(elementValue);
        driver.quit();
        return elementValue;
    }

    public String parseElementByCssSelector (WebDriver driver, String url, String cssSelector) {
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

    public String parseElementByTagAndAttribute(WebDriver driver, String url, String tagName, String attributeName) {
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
