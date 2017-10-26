package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by purushtoman on 16/10/17.
 */
public class SignIn extends BaseClass{
    WebDriver driver;
    private String error,
            frameId = "modal_window";

    @FindBy(linkText = "Your trips")
    private WebElement linkText;

    @FindBy(id = "SignIn")
    private WebElement signIn;

    @FindBy(id = "signInButton")
    private WebElement signInButton;

    @FindBy(id = "errors1")
    private WebElement errors1;

    @FindBy(id="close")
    private WebElement closeBtn;

    public SignIn(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void clickOnSignInButton() {
        linkText.click();
        signIn.click();
    }

    public String loginFlow(){
        driver.switchTo().frame(frameId);
        signInButton.click();
        error = errors1.getText();
        driver.switchTo().defaultContent();
        closeBtn.click();
        return error;
    }
}
