package testNgPractica.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNgPractica.appcode.ClassToTest;

public class testSumar {

    @Test
    public void testMethod1() {
        System.out.println("Running Test -> sumar 2 numeros");
        ClassToTest obj = new ClassToTest();
        int result = obj.sumarNumeros(2, 1);
        Assert.assertEquals(result,3);
    }

    @Test
    public void testMethod2() {
        System.out.println("Running Test -> Concatenar");
        String valor = "hola todos";
        ClassToTest obj = new ClassToTest();
        String mensaje = obj.concatenar("hola","todos");
        Assert.assertEquals(mensaje,valor);
    }

    @Test
    public void testMethod3() {
        System.out.println("Running Test -> retornar Vector");
        ClassToTest obj = new ClassToTest();
        int[] vecEsp = {1,2,3};
        Assert.assertEquals(obj.getVector(),vecEsp);
    }

    @Test
    public void testMethod4(){
        SoftAssert softAssert = new SoftAssert();
        ClassToTest classToTest = new ClassToTest();
        int valor = classToTest.sumarNumeros(1,2);
        softAssert.assertEquals(valor,2);
        System.out.println("Paso el primer assert");
        softAssert.assertEquals(valor,3);
        System.out.println("paso el segundo assert");
        //softAssert.assertAll();
    }

}
