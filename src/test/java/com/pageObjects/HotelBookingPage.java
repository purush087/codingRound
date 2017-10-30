package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by purushtoman on 16/10/17.
 */
public class HotelBookingPage{
    WebDriver driver;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    public HotelBookingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnHotels() {
        hotelLink.click();
    }

    public void bookingDetails(String location, String roomsAndGuests) {
        localityTextBox.sendKeys(location);
        new Select(travellerSelection).selectByVisibleText(roomsAndGuests);
        searchButton.click();
    }

}
