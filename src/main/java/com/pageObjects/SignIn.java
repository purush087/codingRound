package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by purushtoman on 16/10/17.
 */
public class SignIn {
    private WebDriver driver;
    private String error,
            frameId = "modal_window";


    private By linkText = By.linkText("Your trips");
    private By signIn = By.id("SignIn");

    private By signInButton = By.id("signInButton");
    private By errors1 = By.id("errors1");
    private By closeBtn = By.id("close");

    public SignIn(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver clickOnSignInButton(WebDriver driver) {
        driver.findElement(linkText).click();
        driver.findElement(signIn).click();
        return driver;
    }

    public String loginFlow(){
        driver.switchTo().frame(frameId);
        driver.findElement(signInButton).click();
        error = driver.findElement(errors1).getText();
        driver.switchTo().defaultContent();
        driver.findElement(closeBtn).click();
        return error;
    }
}
