import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class User {
    public String username;
    public String email;
    public String password;
    public String password2;

    public User(String username, String email, String password, String password2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static boolean registerUser(User user) {
        DriverStart.driver.get("https://elenta.lt/registracija");
        DriverStart.driver.findElement(By.id("UserName")).sendKeys(user.username);
        DriverStart.driver.findElement(By.id("Email")).sendKeys(user.email);
        DriverStart.driver.findElement(By.id("Password")).sendKeys(user.password);
        DriverStart.driver.findElement(By.id("Password2")).sendKeys(user.password2);
        DriverStart.driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        return checkRegistrationStatus();
    }

    public static boolean checkRegistrationStatus() {
        boolean output = true;

        List<WebElement> successfulRegistration =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        if (successfulRegistration.size() > 0 && successfulRegistration.get(0).getText().equals("Jūs sėkmingai prisiregistravote")) {
            return true;
        }

        List<WebElement> usernameError =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> invalidEmailError =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/span"));
        List<WebElement> passwordTooShortError =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/span"));
        List<WebElement> secondPasswordMismatch =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/span"));

        if (usernameError.size() > 0) {
            System.out.println(usernameError.get(0).getText());
            output = false;
        }

        if (invalidEmailError.size() > 0) {
            System.out.println(invalidEmailError.get(0).getText());
            output = false;
        }

        if (passwordTooShortError.size() > 0) {
            System.out.println(passwordTooShortError.get(0).getText());
            output = false;
        }

        if (secondPasswordMismatch.size() > 0) {
            System.out.println(secondPasswordMismatch.get(0).getText());
            output = false;
        }

        return output;
    }

    public static boolean loginUser(User user) {
        DriverStart.driver.get("https://elenta.lt/prisijungti?returnurl=https%3A%2F%2Felenta.lt%2Fregistracija");
        DriverStart.driver.findElement(By.id("UserName")).sendKeys(user.username);
        DriverStart.driver.findElement(By.id("Password")).sendKeys(user.password);
        DriverStart.driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[4]/td[2]/input")).click();
        return checkLoginStatus();
    }

    public static boolean checkLoginStatus() {
        boolean output = true;

        List<WebElement> successfulLogin =  DriverStart.driver.findElements(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a[3]"));
        if (successfulLogin.size() > 0 && successfulLogin.get(0).getText().equals("mano skelbimai")) {
            return true;
        }

        List<WebElement> incorrectCredentialsError =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[5]/td/div/ul/li"));
        List<WebElement> emptyUsernameError =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/span"));
        List<WebElement> emptyPasswordError =  DriverStart.driver.findElements(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[3]/td[2]/span"));

        if (incorrectCredentialsError.size() > 0) {
            System.out.println(incorrectCredentialsError.get(0).getText());
            output = false;
        }

        if (emptyUsernameError.size() > 0) {
            System.out.println(emptyUsernameError.get(0).getText());
            output = false;
        }

        if (emptyPasswordError.size() > 0) {
            System.out.println(emptyPasswordError.get(0).getText());
            output = false;
        }

        return output;
    }
}