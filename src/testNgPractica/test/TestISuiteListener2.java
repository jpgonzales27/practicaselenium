package testNgPractica.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testNgPractica.Listeners.CustomListener2;
import testNgPractica.Listeners.CustomListener3;

@Listeners(CustomListener3.class)
public class TestISuiteListener2 {
    @BeforeClass
    public void setUp() {
        System.out.println("Code in before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("Code in after class");
    }

    @Test
    public void testMethod1() {
        System.out.println("Code in testMethod1");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod2() {
        System.out.println("Code in testMethod2");
        Assert.assertTrue(false);
    }
}
