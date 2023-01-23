package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalLoginFormCardPage extends TechGlobalBasePage{

    public TechGlobalLoginFormCardPage(){
        super();
    }

    @FindBy(id = "main_heading")
    public WebElement header;

    @FindBy(xpath = "//label[@for='username']")
    public WebElement usernameLabel;

    @FindBy(xpath = "//label[@for='password']")
    public WebElement passwordLabel;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "success_lgn")
    public WebElement messageAfterSuccessfulLogin;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(id = "error_message")
    public WebElement errorMessage;

    @FindBy(css = "p>span")
    public List<WebElement> validCredentials;
}
