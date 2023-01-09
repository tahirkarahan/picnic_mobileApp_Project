package com.picnic.pages;

import com.picnic.utility.TestUtility;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    TestUtility testUtility;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        testUtility = new TestUtility(driver);
    }

    @AndroidFindBy(accessibility = "login")
    MobileElement loginBtn;

    @AndroidFindBy(accessibility = "+1")
    MobileElement countryCode;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement countyCodeSearchBar;

    @AndroidFindBy(accessibility = "+90 Turkey")
    MobileElement targetCountryCode;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement phoneNumField;

    @AndroidFindBy(accessibility = "Sign in with Google")
    MobileElement signInWithGoogleLink;

    @AndroidFindBy(className = "android.widget.Button")
    MobileElement countryDropdownList;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement countySearchBar;

    @AndroidFindBy(accessibility = "Turkey")
    MobileElement targetCountry;

    @AndroidFindBy(xpath = "(//*[@class=\"android.widget.LinearLayout\"])[14]")
    MobileElement emailAddress;

    @AndroidFindBy(accessibility = "\uD83C\uDDFA\uD83C\uDDF8\n" + "english")
    MobileElement language;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement age;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement userName;

    @AndroidFindBy(className = "android.widget.Button")
    MobileElement skipBtn;

    @AndroidFindBy(accessibility = "welcome to picnic")
    MobileElement messageTitle;

    @AndroidFindBy(accessibility = "Congrats! you’re in. Let's find some awesome circles for you to join.")
    MobileElement successfulMessage;

    public void clickOnLoginBtn() {
        loginBtn.click();

    }

    public MobileElement getContinueBtn() {
        return (MobileElement) driver.findElement(MobileBy.AccessibilityId("continue"));
    }

    public void loginWithPhoneNumber(String phone) {
        countryCode.click();
        countyCodeSearchBar.click();
        TestUtility.sleep(3);
        countyCodeSearchBar.sendKeys("+90");
        targetCountryCode.click();
        TestUtility.sleep(2);
        phoneNumField.click();
        phoneNumField.sendKeys(phone);
        getContinueBtn().click();
        TestUtility.sleep(30);
        if (getContinueBtn().isEnabled()) {
            getContinueBtn().click();
        }
        TestUtility.sleep(35);
    }

    public void loginWithGoogleAccount() {
        signInWithGoogleLink.click();
        TestUtility.sleep(5);
        emailAddress.click();
        countryDropdownList.click();
        countySearchBar.click();
        countySearchBar.sendKeys("+90");
        targetCountry.click();
        getContinueBtn().click();
        language.click();
        getContinueBtn().click();
    }

    public void inputPersonalInfo() {
        age.click();
        age.sendKeys("25");
        getContinueBtn().click();
        TestUtility.sleep(3);
        userName.click();
        userName.sendKeys(TestUtility.generateFakeFirsName());
        getContinueBtn().click();
        TestUtility.sleep(3);
        skipBtn.click();
        TestUtility.sleep(3);

    }

//    public void chooseCircles(){
//        chooseCircles.click();
//        confirmForChoose.click();
//        getContinueBtn().click();
//    }

    public boolean verifyLoginSuccessfully() {
        if (messageTitle.isDisplayed() & successfulMessage.isDisplayed()) {
            System.out.println("yuo logged in successfully " + successfulMessage.getText());
            return true;
        } else
            return false;

    }
}
