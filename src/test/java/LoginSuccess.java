import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class LoginSuccess {

    @Test
    public void login() {
        System.out.println("TESTING LOGIN SUCCESS");
        String username = "standard_user";
        String password = "secret_sauce";
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();

        driver = new FirefoxDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        String logoName = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals("Swag Labs", logoName);
    }
}
