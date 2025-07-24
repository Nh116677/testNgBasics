package testNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class annotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @Test
    public void AtestCase(){
        System.out.println("This is test case A");
    }

    @Test
    public void BtestCase(){
        System.out.println("This is test case B");
    }

    @Test
    public void CtestCase(){
        System.out.println("This is test case C");
    }

    @AfterMethod
    public void afterMethod (){
        System.out.println("I am after method");
    }
}
