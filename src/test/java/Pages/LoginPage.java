package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement getUsernameField;

    public void inputValidUsername() {
        getUsernameField.sendKeys("standard_user");
    }
    public void inputInvalidUsername(String invalidUsername) {
        getUsernameField.sendKeys(invalidUsername);
    }
    public void inputEmptyUsername() {
        getUsernameField.sendKeys("");
    }
    @FindBy(id = "password")
    public WebElement getPasswordField;

    public void inputValidPassword() {
        getPasswordField.sendKeys("secret_sauce");
    }
    public void inputInvalidPassword(String invalidPassword) {
        getPasswordField.sendKeys(invalidPassword);
    }
    public void inputEmptyPassword() {
        getPasswordField.sendKeys("");
    }
    @FindBy(id = "login-button")
    public WebElement getLoginButton;

    public void clickOnLoginButton() {
        getLoginButton.click();
    }
    @FindBy(css = "h3[data-test=error]")
    public WebElement getErrorMessage;

    public void userLogin(){
        inputValidUsername();
        inputValidPassword();
        clickOnLoginButton();
    }
}
