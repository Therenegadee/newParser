package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FirstPageConnecter {

    FirstPageConnecter () {}

    public void connectToFirstPage (String urlForFirstPage, WebDriver driver) {
        driver.get(urlForFirstPage);
    }
}
