package tests.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests.BaseTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class BaseMethodUiTest extends BaseTest {

    @BeforeMethod
    public void baseUiSetup() throws MalformedURLException {
        boolean isRemote = false;//need to read from properties
        String baseUrl = "https://google.com";//need to read from properties
        if (isRemote == true) {
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
            Selenide.open(baseUrl);
        } else {
            Selenide.open(baseUrl);
        }
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
