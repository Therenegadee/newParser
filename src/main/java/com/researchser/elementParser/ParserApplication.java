package com.researchser.elementParser;

import com.researchser.browserActions.BrowserSetter;
import com.researchser.browserActions.FirstPageConnecter;
import com.researchser.elementParser.htmlElementParser.ParseElement;
import com.researchser.elementParser.settingsForParsing.PagesToParseLinksGetter;
import com.researchser.elementParser.settingsForParsing.ParseElementAdder;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ParserApplication {
    public static void main(String[] args) {
        BrowserSetter browserConnecter = new BrowserSetter();
        FirstPageConnecter firstPageConnecter = new FirstPageConnecter();
        PagesToParseLinksGetter pagesToParseLinksGetter = new PagesToParseLinksGetter();
        ParseElementAdder parseElementAdder = new ParseElementAdder();

        List<String> linksToPagesForParse = new ArrayList<>();
        List<ParseElement> parsingTypes = new ArrayList<>();

        WebDriver driver = browserConnecter.setBrowserDriver();

        firstPageConnecter.connectToFirstPage("https://zhongchou.modian.com/all/top_comment/all/1", driver);

        linksToPagesForParse = pagesToParseLinksGetter.getPagesToParseLinks(driver, 2, "pc_ga_pro_index_17",
                "a", "body > div > div.pro_field > div > div > a.next");

        parsingTypes = parseElementAdder.addElementsToParse(driver);

        for (String link : linksToPagesForParse) {
                driver.get(link);
                for(ParseElement parseElement : parsingTypes) {
                    parseElement.parseByParameters(link);
                    System.out.println(parseElement.parseByParameters(link));
                }
        }
        driver.quit();
    }
}
