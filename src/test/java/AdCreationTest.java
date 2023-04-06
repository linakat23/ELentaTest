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
    public void lettersPriceTest() {
        assertFalse(Ad.adCreation(new Ad("smth", "smth smth","abc","Vilnius","876766787","emeilas@emeilas.com")));
    }

    @Test(priority = 3)
    public void gibberishCityOrDistrictTest() {
        assertFalse(Ad.adCreation(new Ad("smth", "smth smth","abc","fdssdf","876766787","emeilas@emeilas.com")));
    }

    @Parameters({"title3", "description3", "price3", "city3", "phone3", "email3"})
    @Test(priority = 4)
    public void successfulAdUpload(String title3, String description3, String price3, String city3, String phone3, String email3) {
        assertTrue(Ad.adCreation(new Ad(title3, description3, price3, city3, phone3, email3)));
    }

    @BeforeClass
    public void beforeClass() {
        Ad.driver = new ChromeDriver();
        Ad.driver.manage().window().maximize();
        Ad.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Ad.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_KinasKnygosMuzika&actionId=Siulo&returnurl=%2Fpatalpinti%2Fivesti-informacija");
        Ad.driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    @AfterClass
    public void afterClass() {
        //    driver.quit();
    }
}
