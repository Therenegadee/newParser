package com.researchser.elementParser.browserSettings.browserSettings;

import com.researchser.elementParser.browserSettings.DTOs.AbstractBrowserSetter;
import com.researchser.elementParser.browserSettings.DTOs.OperatingSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements AbstractBrowserSetter {

    @Override
    public WebDriver setBrowser(OperatingSystem operatingSystem) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if (operatingSystem.equals(OperatingSystem.WINDOWS)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver_windows32.exe");
        } else if (operatingSystem.equals(OperatingSystem.MAC_OS)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver_macOS");
        } else if (operatingSystem.equals(OperatingSystem.LINUX)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver_linux64");
        } else {
            System.err.println("Неверный ввод браузера");
        }
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
