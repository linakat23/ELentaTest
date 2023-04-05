import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class User {
    public String username;
    public String email;
    public String password;
    public String password2;
    public static WebDriver driver;

    public User(String username, String email, String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    public static boolean registerUser(User user) {
    driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[10]/td/p/a")).click();
    driver.findElement(By.id("UserName")).sendKeys(user.username);
    driver.findElement(By.id("Email")).sendKeys(user.email);
    driver.findElement(By.id("Password")).sendKeys(user.password);
    driver.findElement(By.id("Password2")).sendKeys(user.password2);
    driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
    return true;
    }

//    public static boolean checkRegistrationFromStatus() {
//        boolean output = true;
//
//        if (driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span")).isEmpty()) {
//        }
//        return true;
//    }
}
