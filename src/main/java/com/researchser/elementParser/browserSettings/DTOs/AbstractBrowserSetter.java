package com.researchser.elementParser.browserSettings.DTOs;

import org.openqa.selenium.WebDriver;

public interface AbstractBrowserSetter {
    WebDriver setBrowser (OperatingSystem operatingSystem);
}
