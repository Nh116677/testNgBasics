package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class dataProvider {

    @DataProvider(name = "credentials")
    public Object[][] data (){
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password is Empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }
    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(dataProvider = "credentials")
    public void loginTest(String usrname, String pass, String ErrorMsg){
        //locating the username
        WebElement username = driver.findElement(By.xpath("//input[@name = 'txtUsername']"));
        username.sendKeys(usrname);
        //locating the password field
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys(pass);
        //locating the loginButton
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name = 'Submit']"));
        loginBtn.click();
        // get the error message
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMessage = error.getText();
        //assertion to verify
        Assert.assertEquals(actualErrorMessage,ErrorMsg);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
