package com.researchser.elementParser.browserSettings.DTOs;

import java.util.Scanner;

public enum BrowserType {
    CHROME("Google Chrome"),
    FIREFOX("Mozilla Firefox");

    public final String label;

    BrowserType(String label) {
        this.label = label;
    }

    public static BrowserType chooseBrowserType () {
        BrowserType type = null;
        while (type == null) {
            System.out.println("Выберите браузер (введите число):\n" +
                    "1. Google Chrome;\n" +
                    "2. Mozilla Firefox;\n");

            Scanner scanner = new Scanner(System.in);
            int numOfElement = scanner.nextInt();

            switch (numOfElement) {
                case 1 -> type = BrowserType.CHROME;
                case 2 -> type = BrowserType.FIREFOX;
                default -> System.err.println("Неверный ввод числа. Пожалуйста, введите номер заново.");
            }
        }
        return type;
    }
}
