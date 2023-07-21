package com.researchser.browserSettings.browserSettings;

import com.researchser.browserSettings.abstractInterfaces.AbstractBrowserSetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FireFox implements AbstractBrowserSetter {

    @Override
    public WebDriver setBrowser(String operatingSystem) {

        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if (operatingSystem.equalsIgnoreCase("windows")) {
            System.setProperty("webdriver.gecko.driver", "drivers/firefox/firefox_win32.exe");
        } else if (operatingSystem.equalsIgnoreCase("macos")) {
            System.setProperty("webdriver.gecko.driver", "drivers/firefox/firefox_macOS");
        } else if (operatingSystem.equalsIgnoreCase("linux")) {
            System.setProperty("webdriver.gecko.driver", "drivers/firefox/firefox_linux64");
        } else {
            System.err.println("Неверный ввод браузера");
        }

        WebDriver driver = new ChromeDriver();

        return driver;
    }
}