package Tests;

import Base.BaseTest;
import Pages.Homepage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomepageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        homepage = new Homepage();
        loginPage = new LoginPage();
    }
    @Test(priority = 10)
    public void userCanClickOnAddToCartButtons() {
        loginPage.userLogin();
        homepage.clickOnAddToCartButtons();
        Assert.assertTrue(homepage.getBadge.isDisplayed());
        Assert.assertTrue(homepage.getRemoveButton1.isDisplayed());
        Assert.assertTrue(homepage.getRemoveButton2.isDisplayed());
    }
    @Test(priority = 20)
    public void userCanClickOnRemoveButton() {
        loginPage.userLogin();
        homepage.clickOnRemoveButtons();
        Assert.assertTrue(homepage.getAddToCartButton1.isDisplayed());
        Assert.assertTrue(homepage.getAddToCartButton2.isDisplayed());
    }
    @Test(priority = 30)
    public void userCanClickOnAboutSectionInHamburgerMenu() {
        loginPage.userLogin();
        homepage.clickOnHamburgerMenu();
        homepage.clickOnAbout();
        String expectedURL = "https://saucelabs.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @Test(priority = 40)
    public void userCanClickOnDropdownMenu() {
        loginPage.userLogin();
        homepage.clickOnDropdown();
        homepage.clickOnElement("Name (A to Z)");
    }
    @Test(priority = 50)
    public void userCanClickOnCartContainer() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        String expectedURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
