package com.cydeo.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    // we want only subclasses of TestBase have access to this.
    protected WebDriver driver;
    // setting up all driver stuff here directly
    @BeforeMethod
    public void setupMethod() {
        driver =  Driver.getDriver() ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {
        //driver.quit();
        // quit the browser + make it null, so we can get new one when ask for it again
        Driver.closeBrowser();
    }


}
