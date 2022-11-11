package ui.rozetka;

import com.codeborne.selenide.impl.ThreadLocalSelenideDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    ThreadLocalSelenideDriver driver = new ThreadLocalSelenideDriver();

    @BeforeMethod
    public void parentSetUp() {
        //System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver.open();
    }

    public WebDriver getDriver(){
        return driver.getWebDriver();
    }

    @AfterMethod
    public void parentTearDown() {
        driver.close();
    }
}
