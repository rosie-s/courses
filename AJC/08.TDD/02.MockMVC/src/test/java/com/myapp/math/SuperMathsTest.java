package com.myapp.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperMathsTest {

    @Test
    public void additionOfIntegers() {
        SuperMaths tester = new SuperMaths();
        //Assert Statements
        assertEquals(5, tester.addition(3, 2), "True: 3 + 2 is 5");
        assertEquals(9, tester.addition(7, 2), "False: 7 + 2 must be 9");

    }

    @Test
    public void subtractionOfIntegers() {
        SuperMaths tester = new SuperMaths();
        //Assert Statements
        assertEquals(5, tester.subtraction(7, 2), "True: 7 - 2 is 5");
        assertEquals(3, tester.subtraction(5, 2), "True: 5 - 2 must be 3");

    }


}
