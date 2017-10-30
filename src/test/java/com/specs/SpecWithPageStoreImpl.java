package com.specs;

import com.pageObjects.FlightBookingPage;
import com.pageObjects.HotelBookingPage;
import com.pageObjects.SignInPage;
import com.pageTests.PageStore;
import org.openqa.selenium.WebElement;

public class SpecWithPageStoreImpl {

    SignInPage onSignInPage;
    HotelBookingPage onHotelBookingPage;
    FlightBookingPage onFlightBookingPage;
    PageStore pageStore;

    public SpecWithPageStoreImpl(PageStore pageStore){
        this.pageStore = pageStore;
    }

   /* public SpecWithPageStoreImpl(SignInPage onSignInPage){
        this.onSignInPage = onSignInPage;
    }
*/
    public void clickOnSignInButton(){
        onSignInPage = pageStore.get(SignInPage.class);
        onSignInPage.clickOnSignInButton();
    }

    public String signIn(){
        onSignInPage = pageStore.get(SignInPage.class);
        return onSignInPage.loginFlow();
    }

    public WebElement choosesOneWayJourney(){
        onFlightBookingPage = pageStore.get(FlightBookingPage.class);
        onFlightBookingPage.setFromLocation("Bangalore");
        onFlightBookingPage.setToLocation("Delhi");
        onFlightBookingPage.destinationOptions();
        //all fields filled in. Now click on search
        WebElement searchSummary = onFlightBookingPage.clickSearch();
        return searchSummary;
    }

    public void clickOnHotelsLink(){
        onHotelBookingPage = pageStore.get(HotelBookingPage.class);
        onHotelBookingPage.clickOnHotels();
    }

    public void searchForHotels(String location, String guests){
        onHotelBookingPage = pageStore.get(HotelBookingPage.class);
        onHotelBookingPage.bookingDetails(location, guests);
    }

}
