import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2F");
    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    driver.findElement(By.xpath("//*[@id=\"form\"]/fieldset/table/tbody/tr[10]/td/p/a")).click();
    driver.findElement(By.id("UserName")).sendKeys(user.username);
    driver.findElement(By.id("Email")).sendKeys(user.email);
    driver.findElement(By.id("Password")).sendKeys(user.password);
    driver.findElement(By.id("Password2")).sendKeys(user.password2);
    driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
    return true;
    }




}
