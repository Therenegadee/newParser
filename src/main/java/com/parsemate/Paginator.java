package com.parsemate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class Paginator {

    Paginator() {
    }

    public void clickNextPageButton (WebDriver driver, String cssSelectorNextPage) {
        WebElement nextPageButton = driver.findElement(By.cssSelector(cssSelectorNextPage)); // "body > div > div.pro_field > div > div > a.next"
        nextPageButton.click();
    }

}
