package ui.rozetka;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import configreader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static pages.rozetkapage.RozetkaPage.*;

public class RozetkaTest extends BaseTest {

   /* @BeforeClass
    public void setUpSelenoid() throws MalformedURLException {
        //настройки в пропертях - selenoid
        FrameworkProperties frameworkProperties =
                ConfigFactory.create(FrameworkProperties.class);
        if (frameworkProperties.getDriverRemote()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "103.0");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
            WebDriverRunner.setWebDriver(driver);
            Selenide.open(frameworkProperties.getBaseUrl());
        } else {
            Selenide.open(frameworkProperties.getBaseUrl());
        }
    }*/

    @Test (testName = "Rozenka have to button 'Buy'",
            description = "Checking if the product is in stock, then the 'Buy' button is enabled")
    public void rozetkaIsEnabledButton(){
        getDriver().get("https://rozetka.com.ua");
        openRozetkaGoods();
        $("[class='product__buy']").shouldBe(visible).isEnabled();
    }

    @Test (testName = "Rozenka login/password forms button",
            description = "Check if all the fields of the login/password form are filled in, then the 'Login' button is enabled")
    public void rozetkaCheckLoginFormLoginPasswordButton(){
        getDriver().get("https://rozetka.com.ua");
        openRozetkaLoginForm();
        $("[class='modal__content']")
                .shouldBe(visible);

        $x("//label[text()=' Ел. пошта або телефон ']")
                .shouldHave(Condition.text("Ел. пошта або телефон"));
        $("[id='auth_email']")
                .pressEnter()
                .setValue("Check Email");

        $x("//label[text()=' Пароль ']")
                .shouldHave(Condition.text(" Пароль "));
        $("[id='auth_pass']")
                .pressEnter()
                .setValue("Check password");

        $x("//button[contains(@class, 'auth-modal__submit ng-star-inserted')]")
                .isEnabled();
    }

    @AfterClass
    public void closeBrowser(){
        Configuration.holdBrowserOpen = false;
    }
}
