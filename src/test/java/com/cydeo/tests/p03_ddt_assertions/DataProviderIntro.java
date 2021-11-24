package com.cydeo.tests.p03_ddt_assertions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class DataProviderIntro {

   // run our tests against different data -- DDT


    @DataProvider(name = "testData")
    public Object[][] dataCreator(){

        // Object[0][0]=Breaking  Bad
        // Object[0][1]= 9
        // Object[0][2]= 4

        // Object[1][0]=Friends
        // Object[1][1]= 9
        // Object[1][2]= 4

        /*



         */

            /*
        Object[][] data1=new Object[3][2];

        data1[0][0]="Breaking Bad";
        data1[0][1]="9";

        data1[1][0]="Breaking Bad";
        data1[1][1]="9";

             */

        Object[][] data={
                {"Breaking Bad","9"},
                {"Friends","9"},
                {"American Horror Story","9"},
                {"Super Woman","9"},
                {"two and a half man","9"},
                {"Yellowstone","9"},

        };

        return data;
    }

    @Test(dataProvider = "testData")
    public void tvShows(String show,String rating) {

        System.out.println("Tv show:"+ show + " has Rating :"+rating);

    }
}
