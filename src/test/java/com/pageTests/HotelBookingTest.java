package com.pageTests;

import org.testng.annotations.Test;

public class HotelBookingTest extends BaseScenario {

    @Test
    public void shouldBeAbleToSearchForHotels(){
        when(user).clickOnHotelsLink();
        then(user).searchForHotels("Indiranagar, Bangalore", "1 room, 2 adults");
    }
}
