package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
public void get_lucky(){

        Lucky13 lucky13 = new Lucky13();

        int[] nums1 = new int[] {
                0,
                2,
                4};
        //  should return true
        int[] nums2 = new int[] {
                1,
                2,
                3};
        //  should return false
        int[] nums3 = new int[] {
                1,
                2,
                4};
        //  should return false
        boolean result1 = lucky13.getLucky(nums1);
        boolean result2 = lucky13.getLucky(nums2);
        boolean result3 = lucky13.getLucky(nums3);

        Assert.assertTrue("The array had no 1s or 3s, should be true.", result1);
        Assert.assertFalse("The array had a 3,should be false.", result2);
        Assert.assertFalse("The array has a 1, should be false.", result3);
    }
}







