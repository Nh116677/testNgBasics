package testNg;

import org.testng.annotations.Test;

public class dependency {

    @Test
    public void loginTestCase(){
        System.out.println("This is login test");
    }

    @Test (dependsOnMethods = {"loginTestCase"})
    public void dashBoardTestCase(){
        System.out.println("This is dashboard test");
    }
}
