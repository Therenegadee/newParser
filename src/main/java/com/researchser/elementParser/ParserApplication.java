package com.researchser.elementParser;

import com.researchser.browserSettings.browserSettings.Browser;
import com.researchser.browserSettings.browserSettings.BrowserType;
import com.researchser.browserSettings.browserSettings.OperatingSystem;
import com.researchser.elementParser.htmlElementParser.ParseElement;
import com.researchser.elementParser.settingsForParsing.LinksExtractor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Scanner;

public class ParserApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        LinksExtractor linksExtractor = new LinksExtractor();

        List<String> linksToPagesForParse;
        List<ParseElement> parsingTypes;


        BrowserType browserType = BrowserType.chooseBrowserType();
        OperatingSystem operatingSystem = OperatingSystem.chooseOperatingSystem();

        WebDriver driver = new Browser(browserType, operatingSystem).getDriver();

        String firstPageURL = SCANNER.nextLine(); // https://zhongchou.modian.com/all/top_comment/all/1
        driver.get(firstPageURL);

        linksToPagesForParse = linksExtractor.getPagesToParseLinks(driver);

        parsingTypes = ParseElement.addElementsToParse(driver);

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
