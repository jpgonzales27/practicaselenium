package testNgPractica.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPriority {

    @BeforeClass
    public void setup(){
        System.out.println("metodo beforeClass");
    }

    @AfterClass
    public void cleanup(){
        System.out.println("metodo affterClass");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("primer test que se ejecuta");
    }

    @Test(priority = 1)
    public void test2() {
        System.out.println("segundo test que se ejecuta");
    }

    @Test(priority = 0)
    public void test3() {
        System.out.println("tercer test que se ejecuta");
    }
}
