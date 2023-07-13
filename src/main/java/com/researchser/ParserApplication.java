package com.researchser;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ParserApplication {
    public static void main(String[] args) {
        BrowserSetter browserConnecter = new BrowserSetter();
        FirstPageConnecter firstPageConnecter = new FirstPageConnecter();
        PagesToParseLinksGetter pagesToParseLinksGetter = new PagesToParseLinksGetter();
        ParseElementAdder parseElementAdder = new ParseElementAdder();
        ElementParser11 elementParser = new ElementParser11();

        List<String> linksToPagesForParse = new ArrayList<>();
        List<String> parsingMethods = new ArrayList<>();
        List<String> parameters = new ArrayList<>();


        WebDriver driver = browserConnecter.setBrowserDriver();

        firstPageConnecter.connectToFirstPage("https://zhongchou.modian.com/all/top_comment/all/1", driver);

        linksToPagesForParse = pagesToParseLinksGetter.getPagesToParseLinks(driver, 2, "pc_ga_pro_index_17",
                "a", "body > div > div.pro_field > div > div > a.next");

        parsingMethods = parseElementAdder.addElementsToParse();

        for (String link : linksToPagesForParse) {
            for (String type : parsingMethods) {
                driver.get(link);
                ParseElement parseElement = new ParseElement(driver, type, parameters);

            }
        }


        driver.quit();
    }
}
