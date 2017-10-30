package com.pageTests;

import com.specs.SpecWithPageStoreImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseScenario {

    @Test
    public void userSignIn(){
        given(user).clickOnSignInButton();
        String error = then(user).signIn();
        Assert.assertTrue(error.contains("There were errors in your submission"));
    }
}
