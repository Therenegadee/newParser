package com.researchser;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class ParseElement {

    private final SearchElementParserStrategy searchElementParserStrategy;
    private final String type;
    private final List<String> parameters;


    public ParseElement(WebDriver driver, String type, List<String> parameters) {
        this.type = type;
        this.parameters = parameters;
        this.searchElementParserStrategy = switch (type) {
            case ("xPath") -> new XPathParser(driver);
            case ("cssSelector") -> new CSSSelectorParser(driver);
            default -> new XPathParser(driver);
        };
    }

    public List<String> parseByParameter(String url) {
        return parameters
                .stream()
                .map(parameter->searchElementParserStrategy.parseByParameters(url, parameter, null))
                .toList();
    }
}
