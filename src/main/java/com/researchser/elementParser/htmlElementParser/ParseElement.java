package com.researchser.elementParser.htmlElementParser;

import com.researchser.elementParser.abstractInterfaces.AbstractParseAlgorithm;
import com.researchser.elementParser.abstractInterfaces.AbstractParseParameter;
import com.researchser.elementParser.htmlElementParser.CSSSelectorParser;
import com.researchser.elementParser.htmlElementParser.TagAttrParser;
import com.researchser.elementParser.htmlElementParser.XPathParser;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ParseElement {

    private final AbstractParseAlgorithm abstractParseAlgorithm;
    private final String type;
    private final List<AbstractParseParameter> parameters;


    public ParseElement(WebDriver driver, String type, List<AbstractParseParameter> parameters) {
        this.type = type;
        this.parameters = parameters;
        this.abstractParseAlgorithm = switch (type) {
            case ("xpath") -> new XPathParser(driver);
            case ("css selector"), ("css") -> new CSSSelectorParser(driver);
            case ("tag+attr"), ("tag") -> new TagAttrParser(driver);
            default -> null;
        };
    }

    public List<String> parseByParameters(String url) {
        return parameters
                .stream()
                .map(parameter -> abstractParseAlgorithm.parseByParameters(parameter, url))
                .toList();
    }
}
