package com.pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseScenario {

    @Test
    public void userSignIn(){
        given(user).clickOnSignInBtn();
        String error = then(user).signIn();
        Assert.assertTrue(error.contains("There were errors in your submission"));
    }
}
