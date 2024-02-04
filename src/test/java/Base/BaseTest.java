package Base;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.Homepage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public Homepage homepage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        excelReader = new ExcelReader("TestData.xlsx");
    }
}
