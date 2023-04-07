import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Ad {
    public String title;
    public String description;
    public String price;
    public String cityOrDistrict;
    public String phoneNumber;
    public String email;

    public Ad(String title, String description, String price, String cityOrDistrict, String phoneNumber, String email) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.cityOrDistrict = cityOrDistrict;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static void adCreationPage1(Ad ad) {
        DriverStart.driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=BuitisLaisvalaikis_KinasKnygosMuzika&actionId=Siulo&returnurl=%2Fpatalpinti%2Fivesti-informacija");
        DriverStart.driver.findElement(By.id("title")).sendKeys(ad.title);
        DriverStart.driver.findElement(By.id("text")).sendKeys(ad.description);
        DriverStart.driver.findElement(By.id("price")).sendKeys(ad.price);
        DriverStart.driver.findElement(By.id("location-search-box")).sendKeys(ad.cityOrDistrict);
        DriverStart.driver.findElement(By.id("phone")).sendKeys(ad.phoneNumber);
        DriverStart.driver.findElement(By.id("email")).sendKeys(ad.email);
        DriverStart.driver.findElement(By.id("submit-button")).click();
    }

    public static void adCreationPage2(Ad ad) {
        DriverStart.driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\linak\\IdeaProjects\\ELentaTest\\src\\main\\resources\\Photo\\Screenshot 2023-04-06 183624.png");
        DriverStart.driver.findElement(By.id("forward-button")).click();
    }

    public static void adCreationPage3(Ad ad) {
        DriverStart.driver.findElement(By.id("forward-button")).click();
    }

    public static boolean adCreation(Ad ad) {
        adCreationPage1(ad);
        if (!adCreationStatusPage1()) {
            return false;
        }
        adCreationPage2(ad);
        if (!adCreationStatusPage2()) {
            return false;
        }
        adCreationPage3(ad);
        if (!adCreationStatusPage3()) {
            return false;
        }
        return true;
    }

    public static boolean adCreationStatusPage1() {
        boolean output = true;

        List<WebElement> successfulUpload = DriverStart.driver.findElements(By.xpath("/html/body/div[1]/h4"));
        if (successfulUpload.size() > 0 && successfulUpload.get(0).getText().equals("SKELBIMAS AKTYVUS")) {
            return true;
        }

        List<WebElement> titleError = DriverStart.driver.findElements(By.id("te"));
        List<WebElement> descriptionError = DriverStart.driver.findElements(By.id("txte"));
        List<WebElement> phoneNumberError = DriverStart.driver.findElements(By.id("ce"));
        List<WebElement> phoneNumberError2 = DriverStart.driver.findElements(By.id("pe"));

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

        if (phoneNumberError2.size() > 0) {
            System.out.println(phoneNumberError2.get(0).getText());
            output = false;
        }

        return output;
    }

    public static boolean adCreationStatusPage2() {
        return true;
    }

    public static boolean adCreationStatusPage3() {
        return true;
    }
}