package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {
    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    public WebElement getCheckoutButton;
    public void clickOnCheckoutButton() {
        getCheckoutButton.click();
    }
    @FindBy(id = "continue-shopping")
    public WebElement getContinueShoppingButton;
    public void clickOnContinueShoppingButton() {
        getContinueShoppingButton.click();
    }
    @FindBy(id = "item_4_title_link")
    public WebElement getItem1Headline;
    @FindBy(id = "item_0_title_link")
    public WebElement getItem2Headline;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement getRemoveButton1;
    public void clickOnRemoveButton1() {
        getRemoveButton1.click();
    }
    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement getRemoveButton2;
    public void clickOnRemoveButton2() {
        getRemoveButton2.click();
    }

    public void clickOnCartRemoveButtons() {
        clickOnRemoveButton1();
        clickOnRemoveButton2();
    }
}
