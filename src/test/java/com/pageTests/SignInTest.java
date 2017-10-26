package com.pageTests;

import com.pageObjects.SignIn;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends DriverFactory {

    SignIn signInPage;

    @Test
    public void clickOnSignInButton(){
        signInPage = new SignIn(driver);
        signInPage.clickOnSignInButton();
        String error = signInPage.loginFlow();
        Assert.assertTrue(error.contains("There were errors in your submission"));
    }

    @Test
    public void foo(){
        signInPage = new SignIn(driver);
        signInPage.clickOnSignInButton();
        String error = signInPage.loginFlow();
        Assert.assertTrue(error.contains("There were errors in your submission"));
    }


}
