package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.Homepage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        homepage = new Homepage();
        loginPage = new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }
    @Test(priority = 10)
    public void userCanFillFieldsAndClickOnContinueButton() {
        loginPage.userLogin();
        homepage.clickOnAddToCartButtons();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("simon");
        checkoutPage.inputLastName("grace");
        checkoutPage.inputPostalCode("26000");
        checkoutPage.clickOnContinueButton();
        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    @Test(priority = 20)
    public void userCanClickOnCancelButton() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.clickOnCancelButton();
        String expectedURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    @Test(priority = 30)
    public void userCannotClickOnContinueButtonWithEmptyFirstNameField() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputEmptyFirstName();
        checkoutPage.inputLastName("grace");
        checkoutPage.inputPostalCode("26000");
        checkoutPage.clickOnContinueButton();
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(checkoutPage.getErrorMessage.isDisplayed());
    }
    @Test(priority = 40)
    public void userCannotClickOnContinueButtonWithEmptyLastNameField(){
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("simon");
        checkoutPage.inputEmptyLastName();
        checkoutPage.inputPostalCode("26000");
        checkoutPage.clickOnContinueButton();
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(checkoutPage.getErrorMessage.isDisplayed());
    }
    @Test(priority = 50)
    public void userCannotClickOnContinueButtonWithEmptyPostalCodeField() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("simon");
        checkoutPage.inputLastName("grace");
        checkoutPage.inputEmptyPostalCode();
        checkoutPage.clickOnContinueButton();
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(checkoutPage.getErrorMessage.isDisplayed());
    }
    @Test(priority = 60)
    public void userOrderInformationsAreVisibleOnCheckoutOverviewPage() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("simon");
        checkoutPage.inputLastName("grace");
        checkoutPage.inputPostalCode("26000");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(checkoutPage.getCartItemLabel1.isDisplayed());
        Assert.assertTrue(checkoutPage.getCartItemLabel2.isDisplayed());
        Assert.assertTrue(checkoutPage.getOrderInfo.isDisplayed());
    }
    @Test(priority = 70)
    public void UserCanClickOnCancelButtonOnCheckoutOverviewPage() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("simon");
        checkoutPage.inputLastName("grace");
        checkoutPage.inputPostalCode("26000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnCancelButton2();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @Test(priority = 80)
    public void userCanClickOnFinishButtonAndSuccessfullyFinishOrder() {
        loginPage.userLogin();
        homepage.clickOnContainer();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("simon");
        checkoutPage.inputLastName("grace");
        checkoutPage.inputPostalCode("26000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnFinishButton();
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertTrue(checkoutPage.getMessage.isDisplayed());
        checkoutPage.clickOnBackButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
