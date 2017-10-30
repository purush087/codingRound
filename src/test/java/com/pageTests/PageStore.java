package com.pageTests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class PageStore {

    WebDriver driver;
    List<Object> pages;

    public PageStore() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver_linux");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=2560x1600");
        driver = new ChromeDriver();
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

