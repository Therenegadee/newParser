package com.parsemate;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PagesToParseLinksGetter {
    PagesToParseLinksGetter() {
    }

    public List<String> getPagesToParseLinks(WebDriver driver, int numberOfPagesToParse, String className, String tagName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        Paginator paginator = new Paginator();
        List<String> linksToPagesForParse = new ArrayList<>();

        List<WebElement> webElementList = new ArrayList<>();

        for (int i = 0; i < numberOfPagesToParse; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
            List<WebElement> webElementsAddInList = driver.findElements(By.className(className));
            for (WebElement element : webElementsAddInList) {
                webElementList.add(element);
            }
            for (WebElement element : webElementList) {
                try {
                    WebElement linkElement = element.findElement(By.tagName(tagName));
                    String href = linkElement.getAttribute("href");
                    if (href != null && !href.isEmpty()) {
                        linksToPagesForParse.add(href);
                    }
                } catch (StaleElementReferenceException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            webElementsAddInList.clear();
            webElementList.clear();

            paginator.clickNextPageButton(driver, "body > div > div.pro_field > div > div > a.next");
        }
        System.out.println(linksToPagesForParse);
        return linksToPagesForParse;
    }
}
