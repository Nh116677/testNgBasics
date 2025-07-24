package testNg;

import org.testng.annotations.Test;

public class priority {
    @Test(priority = 1)
    public void AtestCase(){
        System.out.println("This is test case A");
    }

    @Test (priority = 3)
    public void BtestCase(){
        System.out.println("This is test case B");
    }

    @Test (priority = 2)
    public void CtestCase(){
        System.out.println("This is test case C");
    }

    @Test
    public void FtestCase(){
        System.out.println("I am test case F");
    }
}

