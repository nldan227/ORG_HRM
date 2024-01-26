package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy (name="username")
    WebElement usernameInput;

    @FindBy (name="password")
    WebElement passwordInput;

    @FindBy (className = "oxd-button")
    WebElement buttonLogin;


    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String username, String password)
    {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        buttonLogin.click();
    }
}
