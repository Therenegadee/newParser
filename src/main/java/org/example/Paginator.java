package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;



public class Paginator {

    Paginator() {
    }

    public Document clickNextPageButton (WebDriver driver) {
        WebElement nextPageButton = driver.findElement(By.cssSelector("body > div > div.pro_field > div > div > a.next"));
        nextPageButton.click();
        Connection connection = Jsoup.connect(driver.getCurrentUrl());
        Document pageForParse = null;
        try {
            pageForParse = connection.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pageForParse;
    }

}
