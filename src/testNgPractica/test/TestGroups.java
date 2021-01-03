package testNgPractica.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGroups {

    @BeforeClass(alwaysRun = true)
    public void Setup(){
        System.out.println("Test BeforeClass");
    }

    @Test(groups = {"cars" , "autos"})
    public void auto1(){
        System.out.println("Test auto 1");
    }

    @Test(groups = {"autos"})
    public void auto2(){
        System.out.println("Test auto 2");
    }

    @Test(groups = {"motos"})
    public void moto1(){
        System.out.println("Test moto 1");
    }

    @Test(groups = {"bicis"})
    public void moto2(){
        System.out.println("Test bici 1");
    }

    @AfterClass(alwaysRun = true)
    public void cleanup(){
        System.out.println("Test AfterClass");
    }

}
