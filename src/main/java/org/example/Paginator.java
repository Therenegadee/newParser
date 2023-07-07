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

    public void clickNextPageButton (WebDriver driver) {
        WebElement nextPageButton = driver.findElement(By.cssSelector("body > div > div.pro_field > div > div > a.next"));
        nextPageButton.click();
    }

}
