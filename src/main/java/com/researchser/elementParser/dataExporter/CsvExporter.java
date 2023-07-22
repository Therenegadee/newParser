package com.researchser.elementParser.dataExporter;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CsvExporter {

    private void exportCSV(List<String> header, List<List<String>> allPagesParseResult) {

        Scanner scanner = new Scanner(System.in);
        FileWriter outputFile = null;

        do {
            System.out.println("Введите путь к куда сохранить файл: ");
            String pathToOutput = scanner.nextLine();
            File file = new File(pathToOutput);
            try {
                outputFile = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Неверный путь к файлу");
            }
        } while (outputFile == null);

        CSVWriter writer = new CSVWriter(outputFile, ';');
        writer.writeNext(header.toArray(String[]::new));
        int i = 0;
        for (List<String> infoList : allPagesParseResult) {
            writer.writeNext(infoList.toArray(String[]::new));
            System.out.printf("Wrote %s row%n", i);
            i++;
        }
    }
}
