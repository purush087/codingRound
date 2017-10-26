package com.pageTests;

import com.pageObjects.FlightBooking;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends DriverFactory {


    private WebElement searchSummary;

    FlightBooking flightBooking;

    @Test
    public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
        flightBooking = new FlightBooking(driver);
        flightBooking.setFromLocation();

        flightBooking.setToLocation();
        flightBooking.destinationOptions();
        //all fields filled in. Now click on search
        searchSummary = flightBooking.clickSearch();
//        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(searchSummary));
    }

    private boolean isElementPresent(WebElement ele) {
        try {
//            driver.findElement(by);
            ele.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
