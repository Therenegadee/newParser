package com.researchser;

import org.openqa.selenium.WebDriver;

public class FirstPageConnecter {

    public void connectToFirstPage (String urlForFirstPage, WebDriver driver) {
        driver.get(urlForFirstPage);
    }
}