package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by purushtoman on 17/10/17.
 */
public class FlightBooking {
    private WebDriver driver;

    private By radioOneWay = By.id("OneWay");
    private By FromTag = By.id("FromTag");
    private By options = By.id("ui-id-1");
    private By options2 = By.id("ui-id-2");
    private By optionsTag = By.tagName("li");
    private By calendarClick = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[2]/a");
    private By dateOfDepartureBox = By.xpath("//*[@id=\"DepartDate\"]");
    private By search = By.id("SearchBtn");
    private By searchSummary = By.className("searchSummary");

    public FlightBooking(WebDriver driver) {
        this.driver = driver;
    }


    public void setFromLocation() {
        driver.findElement(radioOneWay).click();
        driver.findElement(FromTag).clear();
        driver.findElement(FromTag).sendKeys("Bangalore");
    }
    public void setToLocation(){
    List<WebElement> originOptions = driver.findElement(options).findElements(optionsTag);
        originOptions.get(0).click();
        //Changed the Id of the element as the previous id was "toTag" and in the site the id is "ToTag"
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
    }

    public void destinationOptions(){
        List<WebElement> destinationOptions = driver.findElement(options2).findElements(optionsTag);
        destinationOptions.get(0).click();
        driver.findElement(dateOfDepartureBox).click();
        //Changed to valid date xpath location as the date was pointed to previous invalid date that cannot be selected.
        driver.findElement(calendarClick).click();
    }

    public By clickSearch(){
        driver.findElement(search).click();
        return searchSummary;
    }
}