package pages;

import com.codeborne.selenide.Configuration;
import configreader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public static void setUpBasePage(){
        FrameworkProperties frameworkProperties =
                ConfigFactory.create(FrameworkProperties.class);
        Configuration.savePageSource = frameworkProperties.getSavePageSource();
        Configuration.timeout = frameworkProperties.getPageTimeout();
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = frameworkProperties.getBrowserVersion();
        Configuration.holdBrowserOpen = frameworkProperties.getHoldBrowserOpen();
        open (Configuration.baseUrl = frameworkProperties.getBaseUrl());
    }
}
