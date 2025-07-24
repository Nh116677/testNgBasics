package testNg;

import org.testng.annotations.Test;

public class enableDisable {

    @Test(enabled = false)
    public void AtestCase(){
        System.out.println("I am test caseA");
    }

    @Test
    public void BtestCase(){
        System.out.println("I am test caseB");
    }

}
