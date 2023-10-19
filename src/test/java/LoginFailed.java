import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class LoginFailed {

    @Test
    public void login() {
        System.out.println("TESTING LOGIN FAILED");
        String username = "standard_use";
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

        String errorMessage = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
    }
}
