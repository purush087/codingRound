package com;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by purushtoman on 16/10/17.
 */

public class BaseClass {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    //Waits for set duration in milliseconds
    public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    // Adding a method for cross browser testing compatibility
    public void setDriver(String Browser, String URL) {
        switch (Browser){
            case  "Chrome" :
                if (PlatformUtil.isMac()) {
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                }
                if (PlatformUtil.isWindows()) {
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                }
                if (PlatformUtil.isLinux()) {
                    System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
                }

                driver = new ChromeDriver();
                driver.get(URL);
                driver.manage().window().maximize();
                break;
                //Add additional cases here for multiple browsers.
        }
    }
    //Sets Browser type and URL fetched from config file of testNG to run tests
    @Parameters({"Browser", "URL"})
    @BeforeClass
    public void startTest(String Browser,String URL){
        try{
            setDriver(Browser,URL);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
