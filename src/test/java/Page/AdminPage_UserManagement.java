package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AdminPage_UserManagement {
    @FindBy (className = "oxd-input")
    List<WebElement> boxInput;

    @FindBy (className = "oxd-autocomplete-wrapper")
    WebElement autocomplete;

    @FindBy (className = "oxd-select-text")
    List<WebElement> dropdowns;

    @FindBy (className = "oxd-button")
    List<WebElement> buttons;

    public AdminPage_UserManagement(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void searchUsersBYUSERNAME(String userName)
    {
        boxInput.get(1).sendKeys(userName);

    }

    public void buttonSearch()
    {
        buttons.get(1).click();
    }

    public void searchUserBYROLE(WebDriver driver, int role) throws InterruptedException {
        WebElement dropdownRole = dropdowns.get(0);
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.click(dropdownRole);
        for(int i=0; i<=role; i++)
        {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        action.sendKeys(Keys.RETURN).build().perform();


    }

    public void searchUerBYSTATUS(WebDriver driver, int status) throws InterruptedException {
        WebElement dropdownRole = dropdowns.get(1);
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.click(dropdownRole);
        for(int i=0; i<=status; i++)
        {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        action.sendKeys(Keys.RETURN).build().perform();
    }

    public void reset()
    {
        buttons.get(0).click();
    }



    public void addUser(WebDriver driver, int Role, int Status, String Ename, String userName, String password) throws InterruptedException {
        buttons.get(2).click();
        WebElement dropdownRole = dropdowns.get(0);
        Actions act = new Actions(driver);
        act.click(dropdownRole);
        for(int i=0; i<=Role; i++)
        {
            act.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        act.sendKeys(Keys.RETURN).build().perform();

        WebElement dropdownStatus = dropdowns.get(1);
        act.click(dropdownStatus);
        for(int i=0; i<=Status; i++)
        {
            act.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        act.sendKeys(Keys.RETURN).build().perform();
        Thread.sleep(2000);
        autocomplete.click(); Thread.sleep(2000);
        act.sendKeys(Ename).build().perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_DOWN).build().perform();
        act.sendKeys(Keys.RETURN).build().perform();

        boxInput.get(1).sendKeys(userName);
        boxInput.get(2).sendKeys(password);
        boxInput.get(3).sendKeys(password);
        buttons.get(1).click();
    }

}
