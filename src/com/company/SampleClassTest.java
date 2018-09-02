package com.company;
import  org.testng.annotations.AfterTest;
import  org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;



public class SampleClassTest {
    SampleClass sc;
    String str1,str2;
    @BeforeTest
    public void initStringsAndObjects()
    {
        sc = new SampleClass();
        str1 ="abc";
        str2 ="def";
    }
    @Test (priority = 1)
    public void testMergeString()
    {
        Assert.assertNotNull(sc.mergeStrings(str1,str2));
        Assert.assertEquals(sc.mergeStrings(str1,str2),"abcdef");

    }
    @Test(priority = 2)
    public void testMergeStringWithDash()
    {
        Assert.assertNotNull(sc.mergeStringsWithDash(str1,str2));
    }

}