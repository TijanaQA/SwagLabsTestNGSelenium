package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.Homepage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        homepage = new Homepage();
        loginPage = new LoginPage();
        cartPage = new CartPage();
    }
    @Test(priority = 10)
    public void userCanClickOnRemoveButton() {
        loginPage.userLogin();
        homepage.clickOnAddToCartButtons();
        homepage.clickOnContainer();
        Assert.assertTrue(cartPage.getItem1Headline.isDisplayed());
        Assert.assertTrue(cartPage.getItem2Headline.isDisplayed());
        cartPage.clickOnCartRemoveButtons();
        Assert.assertFalse(cartPage.getItem1Headline.isDisplayed());
        Assert.assertFalse(cartPage.getItem2Headline.isDisplayed());
    }
    @Test(priority = 20)
    public void userCanClickOnContinueShoppingButton() {
        loginPage.userLogin();
        homepage.clickOnAddToCartButtons();
        homepage.clickOnContainer();
        cartPage.clickOnContinueShoppingButton();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @Test(priority = 30)
    public void userCanClickOnCheckoutButton() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
