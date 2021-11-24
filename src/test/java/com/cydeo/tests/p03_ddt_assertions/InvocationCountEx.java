package com.cydeo.tests.p03_ddt_assertions;

import org.testng.annotations.Test;

public class InvocationCountEx {


    @Test(invocationCount = 10,timeOut = 16000)
    public void repeatedTest() {
        System.out.println("Test");
    }

}
