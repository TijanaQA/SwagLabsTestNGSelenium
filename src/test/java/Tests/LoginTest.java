package Tests;

import Base.BaseTest;
import Pages.Homepage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage();
        homepage = new Homepage();
    }
    @Test(priority = 10)
    public void userCanLogInWithValidUsernameAndPassword() {
        loginPage.userLogin();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @Test(priority = 20)
    public void userCanLogOut() {
        loginPage.userLogin();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        homepage.clickOnHamburgerMenu();
        homepage.clickOnLogoutButton();
        String expectedURL1 = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL1);
    }
    @Test(priority = 30)
    public void userCannotLogInWithInvalidUsername() {
        String invalidUsername = excelReader.getStringData("LoginCredentials", 1, 0);
        loginPage.inputInvalidUsername(invalidUsername);
        loginPage.inputValidPassword();
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
    }
    @Test(priority = 40)
    public void userCannotLogInWithInvalidPassword() {
        loginPage.inputValidUsername();
        String invalidPassword = excelReader.getStringData("LoginCredentials", 1, 1);
        loginPage.inputInvalidPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
    }
    @Test(priority = 50)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        String invalidUsername = excelReader.getStringData("LoginCredentials", 2, 0);
        String invalidPassword = excelReader.getStringData("LoginCredentials", 2, 1);
        loginPage.inputInvalidUsername(invalidUsername);
        loginPage.inputInvalidPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
    }
    @Test(priority = 60)
    public void userCannotLogInWithEmptyUsernameAndPasswordFields() {
        loginPage.inputEmptyUsername();
        loginPage.inputEmptyPassword();
        loginPage.clickOnLoginButton();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertTrue(loginPage.getErrorMessage.isDisplayed());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

