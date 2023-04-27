import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.time.Duration;

public class RegisterTest {

    @Test
    public void takenUsernameTest() {
        assertFalse(User.registerUser(new User("Jonas", "jonasxjonaitis1@yahoo.com", "testavimas", "testavimas")));
    }

    @Test
    public void symbolsUsernameTest() {
        assertFalse(User.registerUser(new User("&*@_?$%", "jonasxjonaitis1@gmail.com", "testavimas", "testavimas")));
    }

    @Test
    public void digitsUsernameTest() {
        assertFalse(User.registerUser(new User("1020301", "jonasxjonaitis1@inbox.lv", "testavimas", "testavimas")));
    }

    @Test
    public void emptyUsernameTest() {
        assertFalse(User.registerUser(new User("", "jonasxjonaitis1@msn.com", "testavimas", "testavimas")));
    }

    @Test
    public void tooLongUsernameTest() {
        assertFalse(User.registerUser(new User("1111122222333334444455555666667777788888", "jonasxjonaitis1@msn.com", "testavimas", "testavimas")));
    }

    @Test
    public void invalidEmailTest() {
        assertFalse(User.registerUser(new User("Jonasxx1", "jonas11!@#jonaitis", "testavimas", "testavimas")));
    }

    @Test
    public void emailExistsTest() {
        assertFalse(User.registerUser(new User("Jonasxx2", "jonasjonaitis11@yahoo.com", "testavimas", "testavimas")));
    }

    @Test
    public void emptyEmailTest() {
        assertFalse(User.registerUser(new User("Jonasxx2", "", "testavimas", "testavimas")));
    }

    @Test
    public void tooLongEmailTest() {
        assertFalse(User.registerUser(new User("Jonasxx1", "111112222233333444445555566666777778888899999@111112222233333444445555566666777778888899999.com", "testavimas", "testavimas")));
    }

    @Test
    public void tooShortPasswordTest() {
        assertFalse(User.registerUser(new User("Jonasxx1", "jonasxjonaitis1@yahoo.com", "a", "a")));
    }

    @Test
    public void tooLongPasswordTest() {
        assertFalse(User.registerUser(new User("jonelisjonelis", "jonelioemeilas@emeilas.com", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));
    }

    @Test
    public void spacesPasswordTest() {
        assertFalse(User.registerUser(new User("Jonasxx1", "jonasxjonaitis1@yahoo.com", "        ", "        ")));
    }

    @Test
    public void mismatchingPasswordsTest() {
        assertFalse(User.registerUser(new User("Jonasxx1", "jonasxjonaitis1@yahoo.com", "aabbccddee", "eeeeeeeeee")));
    }

    @Test
    public void emptyPasswordsTest() {
        assertFalse(User.registerUser(new User("Jonasxx1", "jonasxjonaitis1@yahoo.com", "", "")));
    }

    @Parameters({"username", "email", "password", "password2"})
    @Test(groups = {"negative"})
    public void usernameEmailPasswordErrorsAtOnceTest(
            @Optional("Jonas") String username,
            @Optional("jonelis") String email,
            @Optional("aa") String password,
            @Optional("bbbb") String password2
    ) {
        assertFalse(User.registerUser(new User(username, email, password, password2)));
    }

    @Test(priority = 13)
    public void registerUserCorrectInputTest() {
        assertTrue(User.registerUser(new User("xyzxyzx3", "xyzxyzx3@yahoo.com", "testavimas", "testavimas")));
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
        DriverStart.driver.quit();
    }
}