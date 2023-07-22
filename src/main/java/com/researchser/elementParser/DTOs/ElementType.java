package com.researchser.elementParser.DTOs;

import java.util.Scanner;

public enum ElementType {
    XPATH("xPath"),
    TAG_ATTR("Tag + Attribute"),
    CSS("CSS Selector");

    public final String label;

    ElementType(String label) {
        this.label = label;
    }

    public static ElementType chooseType () {

        ElementType type = null;
        while (type == null) {
            System.out.println("Выберите элемент парсинга (введите число):\n" +
                    "1. xPath;\n" +
                    "2. CSS Selector;\n" +
                    "3. Tag + Attribute;\n");
            Scanner scanner = new Scanner(System.in);
            int numOfElement = scanner.nextInt();
            switch (numOfElement) {
                case 1 -> type = ElementType.XPATH;
                case 2 -> type = ElementType.CSS;
                case 3 -> type = ElementType.TAG_ATTR;
                default -> System.err.println("Неверный ввод числа. Пожалуйста, введите номер заново.");
            }
        }
        return type;
    }
}
