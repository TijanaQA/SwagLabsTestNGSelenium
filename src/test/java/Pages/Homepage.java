package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends BaseTest {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getElement() {
        return driver.findElements(By.className("product_sort_container"));
    }
    public void clickOnElement(String elementName) {
        for (int i = 0; i < getElement().size(); i++) {
            if (getElement().get(i).getText().equals(elementName)) {
                getElement().get(i).click();
                break;
            }
        }
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement getAddToCartButton1;
    public void clickOnAddToCartButton1() {
        getAddToCartButton1.click();
    }

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement getAddToCartButton2;
    public void clickOnAddToCartButton2() {
        getAddToCartButton2.click();
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement getHamburgerMenu;
    public void clickOnHamburgerMenu() {
        getHamburgerMenu.click();
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement getContainer;
    public void clickOnContainer() {
        getContainer.click();
    }

    @FindBy(className = "product_sort_container")
    public WebElement getDropdownMenu;
    public void clickOnDropdown() {
        getDropdownMenu.click();
    }

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

    @FindBy(className = "shopping_cart_badge")
    public WebElement getBadge;

    @FindBy(linkText = "About")
    public WebElement getAbout;
    public void clickOnAbout() {
        getAbout.click();
    }

    @FindBy(linkText = "All Items")
    public WebElement getAllItems;
    public void clickOnAllItems() {
        getAllItems.click();
    }

    @FindBy(linkText = "Reset App State")
    public WebElement getResetAppState;
    public void clickOnResetAppState() {
        getResetAppState.click();
    }

    @FindBy(linkText = "Logout")
    public WebElement getLogoutButton;
    public void clickOnLogoutButton() {
        getLogoutButton.click();
    }

    public void clickOnAddToCartButtons() {
        clickOnAddToCartButton1();
        clickOnAddToCartButton2();
    }
    public void clickOnRemoveButtons() {
        clickOnRemoveButton1();
        clickOnRemoveButton2();
    }
}

