package com.cydeo.tests.p03_ddt_assertions;

import com.cydeo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TypesOfAssertions extends TestBase {
    @Test
    public void hardAssert() {

        driver.get("https://search.yahoo.com");
        String actual=driver.getTitle();
        String expected="Yahoo Search - Web Search";
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        System.out.println("Since it is a hard assert we can't see this line in execution");


    }


    @Test
    public void softAssert() {
        driver.get("https://search.yahoo.com");
        String actual=driver.getTitle();
        String expected="Yahoo Search - Web Searchs";
        System.out.println(actual);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual, expected,"First assertion");

        System.out.println("After first assertion");

        softAssert.assertTrue(true,"Second assertions");

        System.out.println("After second assertion");

        softAssert.assertEquals(actual, expected,"Third assertion");

        System.out.println("After third assertion");

        softAssert.assertAll();
        //compiler start comparison in here
        // it will give all rsults after this line

        System.out.println("After assertAll ");




    }
}
