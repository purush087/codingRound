package com.pageTests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class PageStore {

    WebDriver driver;
    List<Object> pages;

    public PageStore() {
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
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("Platform", Platform.ANY);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "lib/phantomjs");
        System.setProperty("phantomjs.binary.path", "lib/phantomjs");
        driver = new PhantomJSDriver();
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

