package testNgPractica.test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testNgPractica.appcode.ClassToTest;

public class TestDependent {

    ClassToTest obj;

    @BeforeClass
    public void setUp() {
        obj = new ClassToTest();
        System.out.println("before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("after class");
    }

    @Test(dependsOnMethods={ "testMethod2" }, alwaysRun=true)
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("testMethod2");
        int result = obj.sumarNumeros(1, 2);
        Assert.assertEquals(result, 2);
    }

    @Test(dependsOnMethods={ "testMethod1" })
    public void testMethod3() {
        System.out.println("testMethod3");
    }

    @Test
    public void testMethod4() {
        System.out.println("testMethod4");
    }
}
