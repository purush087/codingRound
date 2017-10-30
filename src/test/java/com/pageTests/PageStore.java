package com.pageTests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class PageStore {

    WebDriver WebDriver;
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
        WebDriver = new ChromeDriver();
        pages = new ArrayList<Object>();
    }

    public <T> T get(Class<T> clazz) {
        for (Object page : pages) {
            if (page.getClass() == clazz)
                return (T) page;
        }
        T page = PageFactory.initElements(WebDriver, clazz);
        pages.add(page);
        return page;
    }

    public void destroy() {
        pages.clear();
        WebDriver.quit();
    }

    public WebDriver getDriver() {
        return WebDriver;
    }
}

