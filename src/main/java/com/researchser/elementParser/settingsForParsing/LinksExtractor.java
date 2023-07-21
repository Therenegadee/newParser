package com.researchser.elementParser.settingsForParsing;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinksExtractor {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> getPagesToParseLinks(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        Paginator paginator = new Paginator();
        List<String> linksToPagesForParse = new ArrayList<>();

        System.out.println("Введите кол-во страниц, которые необходимо спарсить: ");
        int numOfPagesToParse = SCANNER.nextInt();
        System.out.println();
        System.out.println("Введите CSS Selector путь кнопки переключения следующей страницы: ");
        String cssSelectorNextPage = SCANNER.nextLine(); // body > div > div.pro_field > div > div > a.next
        System.out.println("Теперь необходимо ввести название класса и тэга, " +
                "по которому парсер будет получать ссылки на элементы страницы");
        System.out.println();
        System.out.println("Введите название класса: ");
        String className = SCANNER.nextLine(); // pc_ga_pro_index_17
        System.out.println();
        System.out.println("Введите название тега: ");
        String tagName = SCANNER.nextLine(); // a

        for (int i = 1; i < numOfPagesToParse; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
            List<WebElement> webElementList = driver.findElements(By.className(className));
            for (WebElement element : webElementList) {
                try {
                    WebElement linkElement = element.findElement(By.tagName(tagName));
                    String href = linkElement.getAttribute("href");
                    if (href != null && !href.isEmpty()) {
                        linksToPagesForParse.add(href);
                    }
                } catch (StaleElementReferenceException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            webElementList.clear();
            paginator.clickNextPageButton(driver, cssSelectorNextPage);
        }
        System.out.println(linksToPagesForParse);
        return linksToPagesForParse;
    }
}
