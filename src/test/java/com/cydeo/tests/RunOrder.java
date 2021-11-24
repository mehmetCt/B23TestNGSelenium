package com.cydeo.tests;

import org.testng.annotations.Test;

public class RunOrder {

    @Test
    public void atest1() {
        System.out.println("d");
    }

    @Test
    public void btest2() {
        System.out.println("a");
    }

    @Test
    public void ctest3() {
        System.out.println("b");
    }
    @Test
    public void dtest4() {
        System.out.println("c");

    }
}
