package com.parsemate;

import org.openqa.selenium.WebDriver;

public class FirstPageConnecter {

    FirstPageConnecter () {}

    public void connectToFirstPage (String urlForFirstPage, WebDriver driver) {

        driver.get(urlForFirstPage);
    }
}
