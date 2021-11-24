package com.cydeo.tests.p03_ddt_assertions;

import com.cydeo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesOfAssertions extends TestBase {
    @Test
    public void hardAssert() {
        driver.get("https://search.yahoo.com");
        String actual=driver.getTitle();
        String expected="Yahoo Search - Web Searchs";
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        System.out.println("Since it is a hard assert we can't see this line in execution");


    }
}
