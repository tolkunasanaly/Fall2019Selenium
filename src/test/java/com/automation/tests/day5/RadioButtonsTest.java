package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));

        //if visible and eligible to click
        if(blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("Clicked on Black Button");
            blackButton.click();
        }else{
            System.out.println("Failed to click on Black Button");
        }
        BrowserUtils.wait(2);
        //how do we verify that button clicked
        //returns true, if button clicked
        if(blackButton.isEnabled()){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED");
        }

        driver.quit();
    }
}
