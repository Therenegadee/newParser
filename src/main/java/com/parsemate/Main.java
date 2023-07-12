package com.parsemate;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {

        BrowserSetter browserConnecter = new BrowserSetter();
        FirstPageConnecter firstPageConnecter = new FirstPageConnecter();
        PagesToParseLinksGetter findAllPagesToParseLinks = new PagesToParseLinksGetter();
        ElementParser elementParser = new ElementParser();

        WebDriver driver = browserConnecter.setBrowserDriver();

        firstPageConnecter.connectToFirstPage("https://zhongchou.modian.com/all/top_comment/all/1", driver);
        findAllPagesToParseLinks.getPagesToParseLinks(driver, 2, "pc_ga_pro_index_17", "a");

        driver.quit();
    }
}