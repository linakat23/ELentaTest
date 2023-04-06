import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LentaLoginTest {

    @Test(priority = 1)
    public void usernamePasswordMismatchTest() {
        assertFalse(User.loginUser(new User("&*@", "testavimas")));
    }

    @Test(priority = 2)
    public void emptyCredentialsTest() {
        assertFalse(User.loginUser(new User("", "")));
    }

    @Test(priority = 3)
    public void successfulLoginTest() {
        assertTrue(User.loginUser(new User("elentajonas", "testavimas")));
    }

    @BeforeClass
    public void beforeClass() {
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        User.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2Fregistracija");
        User.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    @AfterClass
    public void afterClass() {
        //    driver.quit();
    }
}
