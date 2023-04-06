import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.time.Duration;

public class LentaRegisterTest {

    @Ignore
    @Test(priority = 1)
    public void registerUserTest() {
        assertTrue(User.registerUser(new User("Jonas111", "jonasjonaitis11@yahoo.com", "testavimas", "testavimas")));
    }

    @Test (priority = 2)
    public void usernameTakenTest() {
        assertTrue(User.registerUser(new User("Jonas", "jonasjonaitis111@yahoo.com", "testavimas", "testavimas")));
    }

    @Test
    public void invalidEmailTest() {
        assertTrue(User.registerUser(new User("Jonas", "jonasjonaitis", "testavimas", "testavimas")));
    }

    @Test
    public void passwordTooShortTest() {
        assertTrue(User.registerUser(new User("Jonas1", "jonasjonaitis1111@yahoo.com", "aaa", "aaa")));
    }

    @Test
    public void usernameEmailPasswordErrorsAtOnce() {
        assertTrue(User.registerUser(new User("", "jonelis","aa","aa")));
    }

    @BeforeClass
    public void beforeClass() {
       // System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver112.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        User.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2F");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();

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
