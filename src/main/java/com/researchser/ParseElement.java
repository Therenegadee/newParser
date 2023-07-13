package com.researchser;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Scanner;

public class ParseElement {

    private final OneParameterParserInterface oneParameterParserInterface;
    private final TwoParametersParserInterface twoParametersParserInterface;
    private final String type;
    private final List<String> parameters;


    public ParseElement(WebDriver driver, String type, List<String> parameters) {
        this.type = type;
        this.parameters = parameters;
        this.oneParameterParserInterface = switch (type) {
            case ("xPath") -> new XPathParser(driver);
            case ("cssSelector") -> new CSSSelectorParser(driver);
            default -> new XPathParser(driver);
        };
        this.twoParametersParserInterface = switch (type) {
            case ("tag+attr") -> new TagAttrParser(driver);
            default -> new TagAttrParser(driver);
        };
    }

    public List<String> parseByOneParameter(String url) {
        return parameters
                .stream()
                .map(parameter -> oneParameterParserInterface.parseByParameters(url, parameter))
                .toList();
    }

    public List<String> parseByTwoParameters(String url) {
        return parameters
                .stream()
                .map(parameter -> twoParametersParserInterface.parseByParameters(url, parameter, parameter))
                .toList();
    }

    public void addOneParsingParameter (String parameter) {
        this.parameters.add(parameter);
    }

    public void removeOneParsingParameter () {
        parametersToString();
        System.out.println("Введите позицию параметра для удаления: ");
        Scanner scanner = new Scanner(System.in);
        int positionOfParameter = scanner.nextInt();
        this.parameters.remove(positionOfParameter-1);
    }

    private void parametersToString () {
        System.out.println("Параметры ранее добавленные вами: " +
                "1:" + parameters.get(0) +
                "2:" + parameters.get(1) +
                "3:" + parameters.get(2) +
                "4:" + parameters.get(3) +
                "5:" + parameters.get(4) +
                "6:" + parameters.get(5));
    }
}
