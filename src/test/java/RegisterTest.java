import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.time.Duration;

public class RegisterTest {

    @Test(priority = 1)
    public void takenUsernameTest() {
        assertFalse(User.registerUser(new User("Jonas", "jonasjonaitis212121@yahoo.com", "testavimas", "testavimas")));
    }

    @Test(priority = 2)
    public void symbolsUsernameTest() {
        assertFalse(User.registerUser(new User("&*@_?$%", "jonasjonaitisjonas@gmail.com", "testavimas", "testavimas")));
    }

    @Test(priority = 3)
    public void digitsUsernameTest() {
        assertFalse(User.registerUser(new User("1020301", "jonasjonaitis@inbox.lv", "testavimas", "testavimas")));
    }

    @Test(priority = 4)
    public void emptyUsernameTest() {
        assertFalse(User.registerUser(new User("", "jonas1jonaitis@msn.com", "testavimas", "testavimas")));
    }

    @Test(priority = 5)
    public void invalidEmailTest() {
        assertFalse(User.registerUser(new User("Jonas12345", "jonas11!@#jonaitis", "testavimas", "testavimas")));
    }

    @Test(priority = 6)
    public void emailExistsTest() {
        assertFalse(User.registerUser(new User("Joonnaass", "jonasjonaitis11@yahoo.com", "testavimas", "testavimas")));
    }

    @Test(priority = 7)
    public void emptyEmailTest() {
        assertFalse(User.registerUser(new User("Jonasregistruojasi", "", "testavimas", "testavimas")));
    }

    @Test(priority = 8)
    public void tooShortPasswordTest() {
        assertFalse(User.registerUser(new User("Jonas987", "jonasjonaitis114511@yahoo.com", "aaa", "aaa")));
    }

    @Test(priority = 9)
    public void spacesPasswordTest() {
        assertFalse(User.registerUser(new User("Jonas1", "jonasjonaitis1111@yahoo.com", "        ", "        ")));
    }

    @Test(priority = 10)
    public void mismatchingPasswordsTest() {
        assertFalse(User.registerUser(new User("viksx1", "jonasjonaitisxxvxx@yahoo.com", "aabbccddee", "eeeeeeeeee")));
    }

    @Test(priority = 11)
    public void usernameEmailPasswordErrorsAtOnceTest() {
        assertFalse(User.registerUser(new User("", "jonelis", "aa", "bbbb")));
    }

    @Test(priority = 12)
    public void registerUserCorrectInputTest() {
        assertTrue(User.registerUser(new User("xyzxyz123", "xyzxyz123@yahoo.com", "testavimas", "testavimas")));
    }

    @BeforeClass
    public void beforeClass() {
        DriverStart.driver = new ChromeDriver();
        DriverStart.driver.manage().window().maximize();
        DriverStart.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverStart.driver.get("https://elenta.lt/registracija");
        DriverStart.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    @AfterClass
    public void afterClass() {
        //    driver.quit();
    }
}