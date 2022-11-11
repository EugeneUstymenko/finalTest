package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configreader.FrameworkProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public static void setUpBasePage(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        //Не работает
        //Configuration.browserCapabilities = new DesiredCapabilities();
        //Configuration.browserCapabilities.setCapability("profile.default_content_setting_values.notifications", 2 );

        FrameworkProperties frameworkProperties =
                ConfigFactory.create(FrameworkProperties.class);
        Configuration.savePageSource = frameworkProperties.getSavePageSource();
        Configuration.timeout = frameworkProperties.getPageTimeout();
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = frameworkProperties.getBrowserVersion();
        Configuration.holdBrowserOpen = frameworkProperties.getHoldBrowserOpen();
        //open (Configuration.baseUrl = frameworkProperties.getBaseUrl());
    }
}
