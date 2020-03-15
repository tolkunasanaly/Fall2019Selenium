package com.automation.tests.vytrack.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

//STATIC IMPOERT OF ALL ASSERTING
import java.security.PublicKey;

import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void tearDown(){
        if (driver !=null){
            driver.quit();
            driver=null;
    }

    }
}
