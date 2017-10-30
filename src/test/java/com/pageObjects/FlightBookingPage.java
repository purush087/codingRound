package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WaitFor;
import java.util.List;

/**
 * Created by purushtoman on 17/10/17.
 */
public class FlightBookingPage {
    WebDriver driver;

    WaitFor wait;

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



    public FlightBookingPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setFromLocation(String location) {
        wait.waitForElementToBeClickable(radioOneWay);
        radioOneWay.click();
        FromTag.clear();
        FromTag.sendKeys(location);
        WebElement opt = wait.waitForElementToBeClickable(options);
        List<WebElement> originOptions = opt.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

    public void setToLocation(String location){
        ToTag.clear();
        ToTag.sendKeys(location);
        WebElement opt = wait.waitForElementToBeClickable(options2);
        List<WebElement> originOptions = opt.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

    public void destinationOptions() {
        dateOfDepartureBox.click();
        wait.waitForElementToBeClickable(calendarClick);
        //Changed to valid date xpath location as the date was pointed to previous invalid date that cannot be selected.
        calendarClick.click();
    }

    public WebElement clickSearch(){
        wait.waitForElementToBeClickable(search);
        search.click();
        return searchSummary;
    }
}