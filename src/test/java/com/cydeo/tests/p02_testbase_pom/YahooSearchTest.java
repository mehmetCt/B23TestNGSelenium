package com.cydeo.tests.p02_testbase_pom;

import com.cydeo.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class YahooSearchTest extends TestBase {


    @Test
    public void testYahooSearchHomePage(){
        driver.get("https://search.yahoo.com") ;
        String expectedTitle = "Yahoo Search - Web Search" ;
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle,"Verify title is matching");
    }

    @Test
    public void testYahooSearchResultPage() throws InterruptedException {
        driver.get("https://search.yahoo.com") ;
        driver.findElement(By.name("p")).sendKeys("selenium" + Keys.ENTER);
        Thread.sleep(1000);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        assertTrue(  driver.getTitle().startsWith("seleniums"),"Verify search page title is selenium" );
    }
}
