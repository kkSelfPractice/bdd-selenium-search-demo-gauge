package com.thoughtworks.gauge.maven.utils;


import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseDriverClass {
    public  static WebDriver driver;
    private WebDriverWait wait;


    public BaseDriverClass(){
        //Path to Driver can be set here using: System.setProperty("webdriver.chrome.driver","/path/to/driver/file");
        driver = setDriver();
    }

    public static WebDriver getDriver(){
        return setDriver();
}

    //Checking and Creating driver instance only once
    private static WebDriver setDriver() {
        if(driver==null){
            //Todo ability to return user required driver e.g. FF,IE etc.
            driver= new ChromeDriver();
        }
        return driver;
    }

    public static void fluentlyWaitUntilElementIsVisible(WebElement element){
        new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

  @AfterSuite
    public void tearDown() {
        driver.quit();
    }

  @BeforeSuite
    public void setUp(){
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      wait = new WebDriverWait(driver,30);
  }

}