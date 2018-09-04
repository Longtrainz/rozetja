package rozetkaTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rozetkaFramework.HomePage;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class RegressionTests extends TestBase {


/*    @Test(priority = 1)
    public void openPageTest() {
        HomePage hp = new HomePage(driver);
        hp.login("test123321@mail.ru","123QWE");
    }
    @Test(priority = 2)
    public void googleTest() {
        driver.get("https://www.google.com.ua/");
        System.out.println("Google");
    }

    @Test(priority = 3)
    public void yandexTest() {
        /// /driver.get("https://yandex.ua/");
        System.out.println("yandex");
    }*/
}
