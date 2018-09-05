package rozetkaTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    String baseUrl;

    @BeforeSuite
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void setUp() {
        baseUrl = ConfigProperties.getTestProperty("url");
        driver.get(baseUrl);
    }

    @AfterSuite
    public void tearDownClass() {
        driver.quit();
    }
}
