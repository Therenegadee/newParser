package org.example;

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

    public String parseElementByTagAndAttribute(WebDriver driver, String url, String tag, String attribute) {
        driver.get(url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement tagElement = driver.findElement(By.tagName(tag));
        String elementValue = tagElement.getAttribute(attribute);
        driver.quit();
        return elementValue;
    }
}
