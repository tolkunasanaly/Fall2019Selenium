package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
    }
    //annotation
    @Test (description = "Verify if method can reverse a string")
    public void test(){
        String expected ="elppa";
        String actual = reverseString("apple");

        Assert.assertEquals(actual, expected);

    }

    @Test (description = "Verify if method can reverse a string")
    public void test2(){
        String expected = " rac";
        String actual =reverseString("car");
        Assert.assertEquals(actual, expected);

    }




    public boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }
    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }


}
