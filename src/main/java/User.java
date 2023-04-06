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
        return checkRegistrationStatus();
    }

    public static boolean checkRegistrationStatus() {
        boolean output = true;

        List<WebElement> usernameEmptyError = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> usernameExistsError = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> invalidEmailError = driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/span"));
        List<WebElement> passwordTooShortError = driver.findElements(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[7]/td[2]/span"));

        if (usernameEmptyError.size() > 0) {
            System.out.println(usernameEmptyError.get(0).getText());
            return false;
        }

        if (usernameExistsError.size() > 0) {
            System.out.println(usernameExistsError.get(0).getText());
            return false;
        }

        if (invalidEmailError.size() > 0) {
            System.out.println(invalidEmailError.get(0).getText());
            return false;
        }

        if (passwordTooShortError.size() > 0) {
            System.out.println(passwordTooShortError.get(0).getText());
            return false;
        }

        return output;
    }
}
