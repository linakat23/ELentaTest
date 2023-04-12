import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    @Test
    public void incorrectCredentialsTest() {
        assertFalse(User.loginUser(new User("&*@", "testavimas")));
    }

    @Test
    public void emptyCredentialsTest() {
        assertFalse(User.loginUser(new User("", "")));
    }

    @Parameters({"username3", "password3"})
    @Test(priority = 3, groups = {"smoke"})
    public void successfulLoginTest(@Optional("elentajonas") String username3, @Optional("testavimas") String password3) {
        assertTrue(User.loginUser(new User(username3, password3)));
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