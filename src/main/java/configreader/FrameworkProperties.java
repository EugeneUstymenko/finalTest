package configreader;

import org.aeonbits.owner.Config;
import org.openqa.selenium.Capabilities;

@Config.Sources("classpath:framework-config.properties")
public interface FrameworkProperties extends Config, Capabilities {

    @Key("configuration.pageLoad.timeout")
    int getPageTimeout();

    @Key("configuration.browserVersion")
    String getBrowserVersion();

    @Key("configuration.savePageSource")
    boolean getSavePageSource();

    @Key("configuration.holdBrowserOpen")
    boolean getHoldBrowserOpen();

    @Key("configuration.baseUrl")
    String getBaseUrl();

    @Key("configuration.driverRemote")
    boolean getDriverRemote();
}
