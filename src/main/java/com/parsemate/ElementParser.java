package com.parsemate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ElementParser {
    ElementParser () {}

    public String parseElementByXpath (WebDriver driver, String url, String xPath) {
        driver.get(url);
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
