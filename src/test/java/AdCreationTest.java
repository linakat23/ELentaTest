import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.time.Duration;

public class AdCreationTest {

    @Test(priority = 1)
    public void onlySpacesInTitleDescriptionAndPhoneTest() {
        assertFalse(Ad.adCreation(new Ad("   ", "   ", "22","Vilnius","   ", "emeilas@emailas.com")));
    }

    @Test(priority = 2)
    public void successfulAdUploadTest() {
        assertTrue(Ad.adCreation(new Ad("Knyga", "Skaityta knyga", "20", "Vilnius", "867633212", "emeilas@emeilas")));
    }
    @Parameters({"title3", "description3", "price3", "city3", "phone3", "email3"})
    @Test(priority = 3,groups = {"smoke"})
    public void successfulAdUploadXMLTest(String title3, String description3, String price3, String city3, String phone3, String email3) {
        assertTrue(Ad.adCreation(new Ad(title3, description3, price3, city3, phone3, email3)));
    }

    @BeforeClass
    public void beforeClass() {
        DriverStart.driver = new ChromeDriver();
        DriverStart.driver.manage().window().maximize();
        DriverStart.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverStart.driver.get("https://elenta.lt/registracija");
        DriverStart.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @AfterClass
    public void afterClass() {
        //    driver.quit();
    }
}
