package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement getFirstName;
    public void inputFirstName(String firstName) {
        getFirstName.sendKeys(firstName);
    }
    public void inputEmptyFirstName() {
        getFirstName.sendKeys("");
    }

    @FindBy(id = "last-name")
    public WebElement getLastName;
    public void inputLastName(String lastName) {
        getLastName.sendKeys(lastName);
    }
    public void inputEmptyLastName() {
        getLastName.sendKeys("");
    }

    @FindBy(id = "postal-code")
    public WebElement getPostalCode;
    public void inputPostalCode(String postalCode) {
        getPostalCode.sendKeys(postalCode);
    }
    public void inputEmptyPostalCode() {
        getPostalCode.sendKeys("");
    }

    @FindBy(id = "continue")
    public WebElement getContinueButton;
    public void clickOnContinueButton() {
        getContinueButton.click();
    }

    @FindBy(id = "cancel")
    public WebElement getCancelButton;
    public void clickOnCancelButton() {
        getCancelButton.click();
    }

    @FindBy(css = "h3[data-test=error]")
    public WebElement getErrorMessage;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[1]/div[3]")
    public WebElement getCartItemLabel1;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[1]/div[4]")
    public WebElement getCartItemLabel2;
    @FindBy(className = "summary_info")
    public WebElement getOrderInfo;

    @FindBy(id = "cancel")
    public WebElement getCancelButton2;
    public void clickOnCancelButton2() {
        getCancelButton2.click();
    }

    @FindBy(id = "finish")
    public WebElement getFinishButton;
    public void clickOnFinishButton() {
        getFinishButton.click();
    }

    @FindBy(className= "complete-header")
    public WebElement getMessage;
    @FindBy(id = "back-to-products")
    public WebElement getBackButton;

    public void clickOnBackButton() {
        getBackButton.click();
    }
}
