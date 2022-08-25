package tests.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseUiTest{

    @BeforeClass
    public void baseUiSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "103.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://192.168.0.102:4444/wd/hub").toURL(),
                capabilities
        );
        WebDriverRunner.setWebDriver(driver);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Test
    public void selenideTest1() {
            open ("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide 1")
                .pressEnter();
        $$x("//h3[contains(text(). 'Selenide')]")
                .filter(visible)
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine"));
    }
    @Test
    public void selenideTest2() {
        open ("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide 1")
                .pressEnter();
        $$x("//h3[contains(text(). 'Selenide')]")
                .filter(visible)
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine"));
    }

    @Test
    public void selenideTest3() {
        open ("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide 1")
                .pressEnter();
        $$x("//h3[contains(text(). 'Selenide')]")
                .filter(visible)
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine"));
    }

    @Test
    public void selenideTest4() {
        open ("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide 1")
                .pressEnter();
        $$x("//h3[contains(text(). 'Selenide')]")
                .filter(visible)
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine"));
    }

    @Test
    public void selenideTest5() {
        open ("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide 1")
                .pressEnter();
        $$x("//h3[contains(text(). 'Selenide')]")
                .filter(visible)
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine"));
    }

    @AfterClass
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}
