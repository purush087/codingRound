package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by purushtoman on 17/10/17.
 */
public class FlightBooking extends BaseClass {
    WebDriver driver;



    @FindBy(id = "OneWay")
    private WebElement radioOneWay;

    @FindBy(id = "FromTag")
    private WebElement FromTag;

    @FindBy(id="ui-id-1")
    private WebElement options;

    @FindBy(id = "ui-id-2")
    private WebElement options2;

    @FindBy(id = "ToTag")
    private WebElement ToTag;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[5]/a")
    private WebElement calendarClick;

    @FindBy(xpath = "//*[@id=\"DepartDate\"]")
    private WebElement dateOfDepartureBox;

    @FindBy(id = "SearchBtn")
    private WebElement search;

    @FindBy(className = "searchSummary")
    private WebElement searchSummary;



    public FlightBooking(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void setFromLocation() {
        // baseClass.waitFor(2000);
        radioOneWay.click();
        FromTag.clear();
        FromTag.sendKeys("Bangalore");
        WebElement opt = waitForElementToBeClickable(options);
        List<WebElement> originOptions = opt.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

    public void setToLocation(){
        ToTag.clear();
        ToTag.sendKeys("Delhi");
        WebElement opt = waitForElementToBeClickable(options2);
        List<WebElement> originOptions = opt.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

    public void destinationOptions() throws InterruptedException {

        /*List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();*/
        dateOfDepartureBox.click();
        Thread.sleep(2000);
        //Changed to valid date xpath location as the date was pointed to previous invalid date that cannot be selected.
        calendarClick.click();
    }

    public WebElement clickSearch(){
        //baseClass.waitFor(2000);
        search.click();
        return searchSummary;
    }
}