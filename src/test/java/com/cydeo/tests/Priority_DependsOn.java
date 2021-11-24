package com.cydeo.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority_DependsOn {


    @Test(priority = 1)
    public void postSpartan() {
        System.out.println("Spartan is Added");

    }

    @Test(priority = 2,dependsOnMethods = {"postSpartan"})
    public void putSpartan() {
        System.out.println("Spartan is Updated with PUT");
    }


    @Ignore
    @Test(priority = 3,dependsOnMethods = {"postSpartan"})
    public void patchSpartan() {
        System.out.println("Spartan is Updated with PATCH");
    }

    @Test(priority = 4,dependsOnMethods = {"postSpartan"})
    public void deleteSpartan() {
        System.out.println("Spartan is Deleted");
    }

    @Test(priority = 5,dependsOnMethods = {"postSpartan"})
    public void getSpartan() {
        System.out.println("Spartan is not Found");
    }
}
