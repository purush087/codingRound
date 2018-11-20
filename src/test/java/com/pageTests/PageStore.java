package com.pageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PageStore {

    WebDriver driver;
    List<Object> pages;

    public PageStore() throws MalformedURLException {
        /*if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver_linux");
        }*/
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=2560x1600");*/
//        driver = new ChromeDriver();
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("Platform", Platform.ANY);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "lib/phantomjs");
        System.setProperty("phantomjs.binary.path", "lib/phantomjs");
        driver = new PhantomJSDriver();*/


        // Desired Capabilities & Options
        DesiredCapabilities firefoxCap = DesiredCapabilities.chrome();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("allow-running-insecure-content");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxCap.setCapability("marionette", true);
        firefoxCap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        firefoxCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxCap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCap);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //Docker Config
       /* DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCaps);*/
        pages = new ArrayList<Object>();
    }

    public <T> T get(Class<T> clazz) {
        for (Object page : pages) {
            if (page.getClass() == clazz)
                return (T) page;
        }
        T page = PageFactory.initElements(driver, clazz);
        pages.add(page);
        return page;
    }

    public void destroy() {
        pages.clear();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

