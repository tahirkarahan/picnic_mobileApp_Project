package com.picnic.utility;

import com.github.javafaker.Faker;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestUtility {
    private static WebDriver driver;

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public static void scrollUp(int xStart, int yStart, int x, int y, WebDriver driver) {
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(xStart, yStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x, y))
                .release().perform();
    }

    public static void implicitWait(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateFakeFirsName() {
        Faker faker = new Faker();
        return faker.name().firstName().toLowerCase();
    }

    public static String generateFakeNumber() {
        Faker faker = new Faker();
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String randomEmailAddress() {
        String generatedString = RandomStringUtils.randomAlphabetic(7);
        return generatedString + "@gmail.com";
    }
}
