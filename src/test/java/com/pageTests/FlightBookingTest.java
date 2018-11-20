package com.pageTests;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners({ReportPortalTestNGListener.class})
public class FlightBookingTest extends BaseScenario {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        WebElement searchSummary = given(user).choosesOneWayJourney();
        Assert.assertTrue(isElementPresent(searchSummary));
    }

    private boolean isElementPresent(WebElement ele) {
        try {
            ele.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
