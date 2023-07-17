package com.researchser.elementParser.htmlElementParser;

import com.researchser.elementParser.abstractInterfaces.AbstractParseAlgorithm;
import com.researchser.elementParser.abstractInterfaces.AbstractParseParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TagAttrParser implements AbstractParseAlgorithm {

    private final WebDriver driver;

    public TagAttrParser (WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public String parseByParameters(AbstractParseParameter abstractParseParameter, String url) {
        TwoParseParameters twoParseParameters = (TwoParseParameters) abstractParseParameter;
        String tagName = twoParseParameters.getParameter1();
        String attributeName = twoParseParameters.getParameter2();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement tagElement = driver.findElement(By.tagName(tagName));
        String elementValue = tagElement.getAttribute(attributeName);
        return elementValue;
    }
}
