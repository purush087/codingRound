package com.pageTests;

import com.BaseClass;
import com.pageObjects.SignIn;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest extends BaseClass {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = getDriver();
    }
    SignIn signinPage;

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing(){
        signinPage =new SignIn(driver);
        waitFor(2000);
        signinPage.clickOnSignInButton(driver);
        waitFor(2000);
        String error = signinPage.loginFlow();
        Assert.assertTrue(error.contains("There were errors in your submission"));
    }
}
