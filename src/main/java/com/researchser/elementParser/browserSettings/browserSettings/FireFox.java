package com.researchser.elementParser.browserSettings.browserSettings;

import com.researchser.elementParser.browserSettings.DTOs.AbstractBrowserSetter;
import com.researchser.elementParser.browserSettings.DTOs.OperatingSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FireFox implements AbstractBrowserSetter {

    @Override
    public WebDriver setBrowser(OperatingSystem operatingSystem) {

        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if (operatingSystem.equals(OperatingSystem.WINDOWS)) {
            System.setProperty("webdriver.gecko.driver", "drivers/firefox/firefox_win32.exe");
        } else if (operatingSystem.equals(OperatingSystem.MAC_OS)) {
            System.setProperty("webdriver.gecko.driver", "drivers/firefox/firefox_macOS");
        } else if (operatingSystem.equals(OperatingSystem.LINUX)) {
            System.setProperty("webdriver.gecko.driver", "drivers/firefox/firefox_linux64");
        } else {
            System.err.println("Неверный ввод браузера");
        }
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}