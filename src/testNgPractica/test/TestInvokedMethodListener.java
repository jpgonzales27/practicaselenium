package testNgPractica.test;

import org.testng.Assert;
import org.testng.annotations.*;
import testNgPractica.Listeners.CustomListener1;

@Listeners(CustomListener1.class)
public class TestInvokedMethodListener {
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
