package com.getmobil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    FileSetting fileSetting = new FileSetting();
    public static ChromeDriver driver = null;
    public static final String USERNAME = "";
    public static final String ACCESS_KEY = "";
    public static final String KEY = USERNAME + ":" + ACCESS_KEY;
    public static final String URL = "http://hub.testinium.io/wd/hub";

    @Before("@WebTest")
    public void chromeWebSetup() throws MalformedURLException {
        if (fileSetting.getXmlPropertyMap().get("isRemote").equals("false")) {
            driver = new ChromeDriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver.get(fileSetting.getXmlPropertyMap().get("environment"));
            driver.manage().window().maximize();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("disable-plugins");
            chromeOptions.addArguments("disable-extensions");

        } else if (fileSetting.getXmlPropertyMap().get("isRemote").equals("true")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("key", KEY);

            capabilities.setCapability(CapabilityType.PLATFORM, "WIN10");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            capabilities.setCapability(CapabilityType.VERSION, "LATEST");
            capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability("recordsVideo", true);
            capabilities.setCapability("screenResolution", "FHD");

            WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
            driver.get("http://www.testinium.com");
        }
    }


    @After("@WebTest")
    public void closeChromeDriver(Scenario scenario) throws InterruptedException {
       /* if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Fail screenshot");
        }*/
        Thread.sleep(5);
        driver.close();
    }

    @After("@Firefox")
    public void closeGeckoDiver(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Fail screenshot");
        }
        driver.close();

    }

    @After("@Explorer")
    public void closeExplorerDiver(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Fail screenshot");
        }
        driver.close();
    }
}
