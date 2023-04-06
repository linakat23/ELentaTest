import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Ad {
    public String title;
    public String description;
    public String price;
    public String cityOrDistrict;
    public String phoneNumber;
    public String email;
    public static WebDriver driver;

    public Ad(String title, String description, String price, String cityOrDistrict, String phoneNumber, String email) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.cityOrDistrict = cityOrDistrict;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static boolean adCreation(Ad ad) {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_KinasKnygosMuzika&actionId=Siulo&returnurl=%2Fpatalpinti%2Fivesti-informacija");
        driver.findElement(By.id("title")).sendKeys(ad.title);
        driver.findElement(By.id("text")).sendKeys(ad.description);
        driver.findElement(By.id("price")).sendKeys(ad.price);
        driver.findElement(By.id("location-search-box")).sendKeys(ad.cityOrDistrict);
        driver.findElement(By.id("phone")).sendKeys(ad.phoneNumber);
        driver.findElement(By.id("email")).sendKeys(ad.email);
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
        driver.findElement(By.id("forward-button")).click();
        return adCreationStatus();
    }

    public static boolean adCreationStatus() {
        boolean output = true;

        List<WebElement> successfulUpload = driver.findElements(By.xpath("/html/body/div[1]/h4"));
        if (successfulUpload.size() >0 && successfulUpload.get(0).getText().equals("SKELBIMAS AKTYVUS")) {
            return true;
        }

        List<WebElement> titleError = driver.findElements(By.xpath("/html/body/div[1]/div[2]/form/div[1]/label/span"));
        List<WebElement> descriptionError = driver.findElements(By.xpath("/html/body/div[1]/div[2]/form/div[2]/label/span"));
        List<WebElement> phoneNumberError = driver.findElements(By.xpath("/html/body/div[1]/div[2]/form/div[5]/span[2]"));

        if (titleError.size() > 0) {
            System.out.println(titleError.get(0).getText());
            output = false;
        }

        if (descriptionError.size() > 0) {
            System.out.println(descriptionError.get(0).getText());
            output = false;
        }

        if (phoneNumberError.size() > 0) {
            System.out.println(phoneNumberError.get(0).getText());
            output = false;
        }

        return output;
    }
}
