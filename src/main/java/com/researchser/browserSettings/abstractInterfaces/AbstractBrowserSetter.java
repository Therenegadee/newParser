package com.researchser.browserSettings.abstractInterfaces;

import com.researchser.browserSettings.browserSettings.OperatingSystem;
import org.openqa.selenium.WebDriver;

public interface AbstractBrowserSetter {
    WebDriver setBrowser (OperatingSystem operatingSystem);
}
