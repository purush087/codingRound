package com.pageTests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverFactory {

    protected WebDriver driver;
    String url = "https://www.cleartrip.com/";


    @BeforeMethod
    public void setup() {
        try {
            System.out.println("-- Inside BeforeMethod --");
            setDriver(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDriver(String url){

        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver_linux");
        }

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}




