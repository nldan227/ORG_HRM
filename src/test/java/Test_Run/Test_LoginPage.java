package Test_Run;

import Page.LoginPage;
import Setup.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_LoginPage extends Setup {
    LoginPage loginPage;

    @Test(priority=1, description = "Login with invalid password")
    public void doFailLogin1() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("Admin","admin234");
        String expectedText = "Invalid credentials";
        String actualText = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Login with SQLInjection")
    public void doFailLogin2  () throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("1=1--","hi'");
        String expectedText = "Invalid credentials";
        String actualText = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        Thread.sleep(2000);

    }

    @Test(priority = 3, description = "Login with valid value")
    public void doLogin ()
    {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("Admin","admin123");
        String expectedURL = "dashboard";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));

    }
}
