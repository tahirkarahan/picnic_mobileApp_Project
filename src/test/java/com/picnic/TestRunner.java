package com.picnic;

import com.picnic.pages.HomePage;
import com.picnic.utility.TestBase;
import com.picnic.utility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner extends TestBase {

    HomePage homePage;
    String phoneNumber = "123456789";

    @BeforeTest
    public void setUp() {
        initilization();
        TestUtility.implicitWait(driver, 20);
    }

    @Test
    public void picnicLoginTest() {
        homePage = new HomePage(driver);
        homePage.clickOnLoginBtn();
       // homePage.loginWithPhoneNumber(phoneNumber);
        homePage.loginWithGoogleAccount();
        homePage.inputPersonalInfo();
        Assert.assertTrue(homePage.verifyLoginSuccessfully());
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
