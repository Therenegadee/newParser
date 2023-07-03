package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GetPagesToParseLinks {
    GetPagesToParseLinks() {
    }

    public List<String> getPagesToParseLinks(WebDriver driver, int numberOfPagesToParse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10l));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pc_ga_pro_index_17")));
        List <String> linksToPagesForParse = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.className("pc_ga_pro_index_17"));
        for (WebElement element : elementList) {
            WebElement linkElement = element.findElement(By.tagName("a"));
            String href = linkElement.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                linksToPagesForParse.add(href);
            } else {
                System.err.println("Невозможно получить ссылку на элемент страницы: " + driver.getCurrentUrl());
            }
        }
        System.out.println(linksToPagesForParse);
        return linksToPagesForParse;
    }
}
