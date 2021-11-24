package com.cydeo.tests.p03_ddt_assertions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utils.ConfigReader;
import com.cydeo.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TryCloudLoginTest extends TestBase {

    @Test(dataProvider = "testData")
    public void positiveLoginTest(String username,String password,String title) {
        driver.get(ConfigReader.read("url"));
        new LoginPage().login(username, password);
        Assert.assertEquals(title, driver.getTitle());

    }

    @DataProvider(name="testData")
    public Object[][] testName() {
        /*
        Object[][] userCredentials=new Object[3][2];

        userCredentials[0][0]="User9";
        userCredentials[0][1]="Userpass123";

        userCredentials[1][0]="User39";
        userCredentials[1][1]="Userpass123";

        userCredentials[2][0]="User65";
        userCredentials[2][1]="Userpass123";
        return userCredentials;

         */

        return new Object[][]{
                {"User9","Userpass123","Dashboaard"},
                {"User39","Userpass123","Dashboard - Trycloud QA"},
                {"User65","Userpass123","Dashboard - Trycloud QA"}
        };

    }
}
