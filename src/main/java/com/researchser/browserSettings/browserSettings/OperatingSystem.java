package com.researchser.browserSettings.browserSettings;

import java.util.Scanner;

public enum OperatingSystem {
    WINDOWS("Windows"),
    MAC_OS("MacOS"),
    LINUX("Linux");

    public final String label;

    OperatingSystem(String label) {
        this.label = label;
    }

    public static OperatingSystem chooseOperatingSystem () {
        OperatingSystem os = null;
        while (os == null) {
            System.out.println("Выберите браузер (введите число):\n" +
                    "1. Windows;\n" +
                    "2. MacOS;\n" +
                    "3. Linux;\n");

            Scanner scanner = new Scanner(System.in);
            int numOfElement = scanner.nextInt();

            switch (numOfElement) {
                case 1 -> os = OperatingSystem.WINDOWS;
                case 2 -> os = OperatingSystem.MAC_OS;
                case 3 -> os = OperatingSystem.LINUX;
                default -> System.err.println("Неверный ввод числа. Пожалуйста, введите номер заново.");
            }
        }
        return os;
    }
}
