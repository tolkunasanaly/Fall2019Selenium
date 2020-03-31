package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     * Pause test for some time
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param elements represents collection of WebElements
     * @return collection of strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            textValues.add(element.getText());
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getScreenshot(String name) {
        String path = System.getProperty("user.dir") + "/test-output/screenshot/" + name + ".png";
        System.out.println("Screenshot is here: "+ path);
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}

