package com.pageTests;

import com.BaseClass;
import com.pageObjects.FlightBooking;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseClass{

    private WebDriver driver;
    private By searchSummary;

    FlightBooking flightBooking;

    @BeforeClass
    public void setup(){
        driver = getDriver();
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        flightBooking = new FlightBooking(driver);

        waitFor(2000);
        flightBooking.setFromLocation();

        //wait for the auto complete options to appear for the origin
        waitFor(2000);
        flightBooking.setToLocation();

        //wait for the auto complete options to appear for the destination
        waitFor(2000);
        //select the first item from the destination auto complete list
        flightBooking.destinationOptions();
        //all fields filled in. Now click on search
        searchSummary = flightBooking.clickSearch();

        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(searchSummary));

        //close the browser
        driver.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
