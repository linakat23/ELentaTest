import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.time.Duration;

public class AdCreationTest {

    @Test
    public void onlySpacesInTitleDescriptionAndPhoneTest() {
        assertFalse(Ad.adCreation(new Ad(" ", " ", "22","Vilnius"," ", "emeilas@emailas.com")));
    }

    @Parameters({"title", "description", "price", "city", "phone", "email"})
    @Test(groups = {"negative"})
    public void emptyTitleDescriptionAndPhoneTest(
            @Optional("") String title,
            @Optional("") String description,
            @Optional("10") String price,
            @Optional("Skuodas") String city,
            @Optional("") String phone,
            @Optional("emeilas@emeilas.com") String email
    ) {
        assertFalse(Ad.adCreation(new Ad(title, description, price, city, phone, email)));
    }

    @Test
    public void incorrectPhoneInputTest() {
        assertFalse(Ad.adCreation(new Ad("Knyga", "Skaityta knyga", "10", "Skuodas", "76564", "emeilas@emeilas.com")));
    }

    @Test
    public void onlyNumbersInDescription() {
        assertFalse(Ad.adCreation(new Ad("Knyga", "1111", "10", "Skuodas", "867633452", "emeilas@emeilas.com")));
    }

    @Test
    public void titleTooLongTest() {
        String str = "12345";
        str = str.repeat(10);
        assertFalse(Ad.adCreation(new Ad(str, "   ", "22","Vilnius","   ", "emeilas@emailas.com")));
    }

    @Test
    public void descriptionTooLongTest() {
        String str = "12345";
        str = str.repeat(100);
        assertFalse(Ad.adCreation(new Ad("title", str, "22","Vilnius","   ", "emeilas@emailas.com")));
    }

    @Test
    public void phoneNumberTooLongTest() {
        assertFalse(Ad.adCreation(new Ad("title", "description", "22","Vilnius", "8656554321234", "emeilas@emailas.com")));
    }

    @Parameters({"title", "description", "price", "city", "phone", "email"})
    @Test(priority = 5, groups = {"smoke"})
    public void successfulAdUploadTest(
            @Optional("Knyga") String title,
            @Optional("Sena skaityta knyga") String description,
            @Optional("12") String price,
            @Optional("Vilnius") String city,
            @Optional("865433454") String phone,
            @Optional("emeilas@emeilas.com")String email
    ) {
        assertTrue(Ad.adCreation(new Ad(title, description, price, city, phone, email)));
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
        DriverStart.driver.quit();
    }
}