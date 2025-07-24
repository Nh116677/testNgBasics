package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class hardAssertions {
    /*
    verify that the login button is enabled
    verify that you are able to login into HRMS website
     */

    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void logintestCase(){
        //locating the username
        WebElement username = driver.findElement(By.xpath("//input[@name = 'txtUsername']"));
        username.sendKeys("Admin");
        //locating the password field
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        //locating the loginButton
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name = 'Submit']"));
        //verify that login button is enabled

        boolean statusOfLoginBtn = loginBtn.isEnabled();
        //statusOfLoginBtn =false
        //assertions
        Assert.assertTrue(statusOfLoginBtn);
        //login in
        loginBtn.click();
        //locate the welcome admin text
        WebElement actualMsg = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualMessage = actualMsg.getText();

        Assert.assertEquals(actualMessage, "Welcome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
