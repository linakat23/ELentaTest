import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.time.Duration;

public class AdCreationTest {

    @Test
    public void successfulAdUpload() {
        assertTrue(Ad.adCreation(new Ad("Moneta", "Labai sena, brangi moneta","27","Vilnius","863455456","moneta@gmail.com")));
    }

    @Test
    public void onlySpacesInTitleDescriptionAndPhoneTest() {
        assertFalse(Ad.adCreation(new Ad("   ", "   ", "22","Vilnius","   ", "emeilas@emailas.com")));
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
