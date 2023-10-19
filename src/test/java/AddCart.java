import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class AddCart {
    @Test
    public void addCart() {
        System.out.println("TESTING ADD CART");
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

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String labelButton = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals("Remove", labelButton);
    }
}
