package com.researchser.elementParser;

import com.researchser.elementParser.browserSettings.browserSettings.Browser;
import com.researchser.elementParser.browserSettings.DTOs.BrowserType;
import com.researchser.elementParser.browserSettings.DTOs.OperatingSystem;
import com.researchser.elementParser.htmlElementParser.ParseElement;
import com.researchser.elementParser.settingsForParsing.LinksExtractor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LinksExtractor linksExtractor = new LinksExtractor();

        List<String> linksToPagesForParse;
        List<ParseElement> parsingTypes;
        List<String> header = new ArrayList<>();

        BrowserType browserType = BrowserType.chooseBrowserType();
        OperatingSystem operatingSystem = OperatingSystem.chooseOperatingSystem();

        WebDriver driver = new Browser(browserType, operatingSystem).getDriver();

        String firstPageURL = SCANNER.nextLine(); // https://zhongchou.modian.com/all/top_comment/all/1
        driver.get(firstPageURL);

        linksToPagesForParse = linksExtractor.getPagesToParseLinks(driver);

        parsingTypes = ParseElement.addElementsToParse(driver, header);

        List<List<String>> allPagesParseResult = new ArrayList<>();

        for (String link : linksToPagesForParse) {
                driver.get(link);
                List<String> pageParseResult = new ArrayList<>();
                for(ParseElement parseElement : parsingTypes) {
                    pageParseResult.add(parseElement.parseByParameters(link));
                }
                allPagesParseResult.add(pageParseResult);
                pageParseResult.clear();
        }
        driver.quit();
    }
}
