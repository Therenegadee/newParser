package org.example;

public class Main {
    public static void main(String[] args) {

        BrowserSetter browserConnecter = new BrowserSetter();
        FirstPageConnecter firstPageConnecter = new FirstPageConnecter();
        Paginator paginator = new Paginator();
        GetPagesToParseLinks findAllPagesToParseLinks = new GetPagesToParseLinks();
        ElementParser elementParser = new ElementParser();

        // WebDriver driver = browserSetter.setBrowserDriver();

        // firstPageConnecter.connectToFirstPage("https://zhongchou.modian.com/all/top_comment/all/1", driver);
        // findAllPagesToParseLinks.getPagesToParseLinks(driver, 3);

        // driver.quit();




    }
}