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

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver111.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
