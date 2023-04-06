import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.time.Duration;

public class LentaRegisterTest {

    @Test (priority = 1)
    public void takenUsernameTest() {
        assertFalse(User.registerUser(new User("Jonas", "jonasjonaitis212121@yahoo.com", "testavimas", "testavimas")));
    }

    @Test (priority = 2)
    public void symbolsUsernameTest() {
        assertFalse(User.registerUser(new User("&*@", "jonasjonaitisjonas@gmail.com", "testavimas", "testavimas")));
    }

    @Test (priority = 3)
    public void digitsUsernameTest() {
        assertTrue(User.registerUser(new User("123123", "jonasjonaitis@inbox.lv", "testavimas", "testavimas")));
    }

    @Test (priority = 4)
    public void emptyUsernameTest() {
        assertFalse(User.registerUser(new User("", "jonas1jonaitis@msn.com", "testavimas", "testavimas")));
    }

    @Test (priority = 5)
    public void invalidEmailTest() {
        assertFalse(User.registerUser(new User("Jonas12345", "jonasjonaitis", "testavimas", "testavimas")));
    }

    @Test (priority = 5)
    public void emailExistsTest() {
        assertFalse(User.registerUser(new User("Joonnaass", "jonasjonaitis11@yahoo.com", "testavimas", "testavimas")));
    }

    @Test (priority = 6)
    public void numbersEmailTest() {
        assertFalse(User.registerUser(new User("Joonassss123", "111@111", "testavimas", "testavimas")));
    }

    @Test (priority = 7)
    public void emptyEmailTest() {
        assertFalse(User.registerUser(new User("Jonasregistruojasi", "", "testavimas", "testavimas")));
    }

    @Test (priority = 8)
    public void tooShortPasswordTest() {
        assertFalse(User.registerUser(new User("Jonas987", "jonasjonaitis114511@yahoo.com", "aaa", "aaa")));
    }

    @Test (priority = 9)
    public void spacesPasswordTest() {
        assertFalse(User.registerUser(new User("Jonas1", "jonasjonaitis1111@yahoo.com", "        ", "        ")));
    }

    @Test (priority = 10)
    public void mismatchingPasswordsTest() {
        assertFalse(User.registerUser(new User("viksx1", "jonasjonaitisxxvxx@yahoo.com", "aabbccddee", "eeeeeeeeee")));
    }

    @Test (priority = 11)
    public void usernameEmailPasswordErrorsAtOnceTest() {
        assertFalse(User.registerUser(new User("", "jonelis","aa","bbbb")));
    }

    @Test (priority = 12)
    public void registerUserCorrectInputTest() {
        assertTrue(User.registerUser(new User("valiovalio123", "jonasj123456789@yahoo.com", "testavimas", "testavimas")));
    }

    @BeforeClass
    public void beforeClass() {
       // System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver112.exe");
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        User.driver.get("https://elenta.lt/registracija");
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