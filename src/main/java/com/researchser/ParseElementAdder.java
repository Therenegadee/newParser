package com.researchser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseElementAdder {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static List<String> parsingMethods = new ArrayList<>();

    public List<String> addElementsToParse() {
        String choice;

        do {
            System.out.println("Добавить метод парсинга? (да/нет)");
            choice = SCANNER.nextLine();

            if (choice.equalsIgnoreCase("да")) {
                System.out.println("Выберите метод парсинга (xpath/css/tag+attribute):");
                String method = SCANNER.nextLine();

                parsingMethods.add(method);
                System.out.println("Метод добавлен.");
            }
        } while (choice.equalsIgnoreCase("да") && parsingMethods.size() < 6);
        return parsingMethods;
    }
}