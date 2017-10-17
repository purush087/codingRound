package com.pageTests;

import com.BaseClass;
import com.pageObjects.HotelBooking;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseClass {
    private WebDriver driver;

    @BeforeClass
    public void setDriver(){
        driver = super.getDriver();
    }

    HotelBooking hotelBooking;

    @Test
    public void shouldBeAbleToSearchForHotels(){
        hotelBooking = new HotelBooking(driver);
        waitFor(2000);
        hotelBooking.clickOnHotels();
        hotelBooking.bookingDetails("Indiranagar, Bangalore", "1 room, 2 adults");
        closeTest();
    }


}
