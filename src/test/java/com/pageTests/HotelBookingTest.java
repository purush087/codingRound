package com.pageTests;

import com.pageObjects.HotelBooking;
import org.testng.annotations.Test;

public class HotelBookingTest extends DriverFactory {

    HotelBooking hotelBooking;

    @Test
    public void shouldBeAbleToSearchForHotels(){
//        waitFor(2000);
        hotelBooking = new HotelBooking(driver);
        hotelBooking.clickOnHotels();
        hotelBooking.bookingDetails("Indiranagar, Bangalore", "1 room, 2 adults");
//        closeTest();
    }


}
