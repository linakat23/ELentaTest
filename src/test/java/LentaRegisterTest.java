import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.time.Duration;

public class LentaRegisterTest {
    public WebDriver driver;

    @Test
    public void registerUserTest(){
        assertTrue(User.registerUser(new User("Jonas", "jonasjonaitis11@yahoo.com", "testavimas", "testavimas")));
    }
//    @Test
//    public void registerUserUsernameTakenTest(){
//        assertTrue(User.registerUser(new User("Jonas", "jonasjonaitis11@yahoo.com", "testavimas", "testavimas")));
//    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver112.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2F");
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();

    }

    @AfterClass
    public void afterClass() {
    //    driver.quit();
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver.get("https://elenta.lt/");
//    }
}
