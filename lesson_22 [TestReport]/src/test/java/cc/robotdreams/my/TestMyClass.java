package cc.robotdreams.my;

import cc.robordreams.my.ClassUnderTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class TestMyClass {
    ClassUnderTest inst;

    @BeforeTest()
    public void setUp() {
        System.out.println("Before test");
        inst = new ClassUnderTest();
    }

    @BeforeMethod(onlyForGroups = {"group1"}, firstTimeOnly = true)
    public void setUp2() {
        System.out.println("BeforeMethod");
    }

    public void unexpected() {
        System.out.println("Unexpected");
    }

    @Test(invocationCount = 10, timeOut = 500, priority = 10)
    public void testStringToLowerCase() {
        System.out.println("testStringToLowerCase");
        String input = "Maria";
        String expectedOutput = "maria";
        String result = inst.methonUnderTest1(input);
        assert expectedOutput.equals(result);
    }

    @Test(timeOut = 5000, priority = 9)  // Disabled because ...
    public void testStringToLowerCase2() {
        System.out.println("testStringToLowerCase2");
        String input = "Maria";
        String expectedOutput = "maria";
        String result = inst.methonUnderTest1(input);
        assert expectedOutput.equals(result);
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test(
            groups = {"group1", "group2"},
            description = "Magic",
            expectedExceptions = IllegalStateException.class,
            expectedExceptionsMessageRegExp = "Too much",
            invocationCount = 10, priority = 50)
    public void testMagic() {
        assert false;
        System.out.println("Magic");
        inst.doSomeMagic();


    }
}