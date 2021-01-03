package testNgPractica.test;

import org.testng.annotations.*;

public class TestDataProvider {

    @Test(dataProvider="inputs" , dataProviderClass = TestData.class)
    public void testMethod1(String input1, String input2) {
        System.out.println("Input 1: " + input1);
        System.out.println("Input 2: " + input2);
    }
}
