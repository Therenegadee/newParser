package com.researchser.elementParser.htmlElementParser;

import com.researchser.elementParser.DTOs.AbstractParseAlgorithm;
import com.researchser.elementParser.DTOs.AbstractParseParameter;
import com.researchser.elementParser.DTOs.OneParseParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CSSSelectorParser implements AbstractParseAlgorithm {

    private final WebDriver driver;

    public CSSSelectorParser(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String parseByParameters(AbstractParseParameter abstractParseParameter, String url) {
        String cssSelector = ((OneParseParameter)abstractParseParameter).getParameter();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        String elementValue = element.getText();
        return elementValue;
    }
}
