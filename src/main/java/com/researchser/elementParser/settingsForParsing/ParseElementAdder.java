package com.researchser.elementParser.settingsForParsing;

import com.researchser.elementParser.htmlElementParser.ParseElement;
import com.researchser.elementParser.abstractInterfaces.AbstractParseParameter;
import com.researchser.elementParser.htmlElementParser.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseElementAdder {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<ParseElement> parsingMethodElements = new ArrayList<>();

    public List<ParseElement> addElementsToParse(WebDriver driver) {
        String choice;
        do {
            System.out.println("Добавить метод парсинга? (да/нет)");
            choice = SCANNER.nextLine();

            if (choice.equalsIgnoreCase("да")) {
                System.out.println("Выберите метод парсинга (xPath/CSS Selector/tag+attribute):");
                String type = SCANNER.nextLine();
                if (type.equalsIgnoreCase("xpath")) {
                    List<AbstractParseParameter> parameters = new ArrayList<>();
                    System.out.println("Введите xPath к элементу: ");
                    String parameter = SCANNER.nextLine();
                    parameters.add(new OneParseParameter(parameter));
                    parsingMethodElements.add(new ParseElement(driver, type, parameters));
                } else if (type.equalsIgnoreCase("tag") || type.equalsIgnoreCase("tag+attribute")) {
                    List<AbstractParseParameter> parameters = new ArrayList<>();
                    System.out.println("Введите Tag элемента (без '<>'): ");
                    String parameter1 = SCANNER.nextLine();
                    System.out.println("Введите Attribute элемента: ");
                    String parameter2 = SCANNER.nextLine();
                    parameters.add(new TwoParseParameters(parameter1, parameter2));
                    parsingMethodElements.add(new ParseElement(driver, type, parameters));
                } else if (type.equalsIgnoreCase("css") || type.equalsIgnoreCase("css selector")) {
                    List<AbstractParseParameter> parameters = new ArrayList<>();
                    System.out.println("Введите CSS Selector элемента: ");
                    String parameter = SCANNER.nextLine();
                    parameters.add(new OneParseParameter(parameter));
                    parsingMethodElements.add(new ParseElement(driver, type, parameters));
                } else {
                    System.out.println("Неверный ввод.");
                    continue;
                }
                System.out.println("Метод добавлен.");
            }
        } while (choice.equalsIgnoreCase("да") && parsingMethodElements.size() < 6);
        return parsingMethodElements;
    }
}