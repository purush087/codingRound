package com.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitFor;


/**
 * Created by purushtoman on 16/10/17.
 */
public class SignInPage {

    WebDriver driver;
    private String error,
            frameId = "modal_window";
    By modalId = By.id(frameId);

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

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnSignInButton() {
        new WaitFor().waitForElementToBeClickable(linkText,driver);
        linkText.click();
        signIn.click();
    }

    public String loginFlow(){
        new WaitFor().presenceOfTheElement(modalId,driver);
        driver.switchTo().frame(frameId);
        signInButton.click();
        error = errors1.getText();
        System.out.println(error);
        driver.switchTo().defaultContent();
        closeBtn.click();
        return error;
    }
}
