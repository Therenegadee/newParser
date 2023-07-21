package com.researchser.browserSettings.browserSettings;


import com.researchser.browserSettings.abstractInterfaces.AbstractBrowserSetter;
import org.openqa.selenium.WebDriver;


public class Browser {

    private final AbstractBrowserSetter abstractBrowserSetter;
    private final WebDriver driver;

    public Browser(BrowserType browserType, OperatingSystem operatingSystem) {
        this.abstractBrowserSetter = switch (browserType) {
            case CHROME -> new Chrome();
            case FIREFOX -> new FireFox();
        };
        this.driver = abstractBrowserSetter.setBrowser(operatingSystem);
    }
    public WebDriver getDriver() {
        return driver;
    }
}

