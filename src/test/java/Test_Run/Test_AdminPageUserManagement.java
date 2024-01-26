package Test_Run;

import Page.AdminPage_UserManagement;
import Page.LoginPage;
import Setup.Setup;
import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Test_AdminPageUserManagement extends Setup {
     LoginPage loginPage;
     AdminPage_UserManagement adminPageUserManagement;
    @BeforeTest
    public void doLogin ()
    {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("Admin","admin123");
        WebElement Admin = driver.findElement(By.xpath("//li[1]//a[1]//span[1]"));
        Admin.click();

    }

    @Test(priority = 1, description = "Search by username")
    public void SearchByName() throws InterruptedException {
        adminPageUserManagement = new AdminPage_UserManagement(driver);
        adminPageUserManagement.searchUsersBYUSERNAME("Admin");
        adminPageUserManagement.buttonSearch();
        Thread.sleep(2000);
        WebElement table = driver.findElement(By.className("oxd-table-body"));
        Utils.scrollDownElement(driver,table);
        List<WebElement> allrows = table.findElements(By.cssSelector("[role=row]"));
        System.out.println(allrows.size());
        for (WebElement row: allrows) {
            List<WebElement> allCells = row.findElements(By.cssSelector("[role=cell]"));
            Assert.assertTrue(allCells.get(1).getText().contains("Admin"));
        }
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Search by role")
    public void SearchByRoleESS() throws InterruptedException {
        adminPageUserManagement = new AdminPage_UserManagement(driver);
        Utils.scrollUp(driver);
        adminPageUserManagement.reset();
        adminPageUserManagement.searchUserBYROLE(driver,1);
        Thread.sleep(2000);
        adminPageUserManagement.buttonSearch();
        Thread.sleep(2000);
        WebElement table = driver.findElement(By.className("oxd-table-body"));
        Utils.scrollDownElement(driver,table);
        List<WebElement> allrows = table.findElements(By.cssSelector("[role=row]"));
        System.out.println(allrows.size());
        for (WebElement row: allrows) {
            List<WebElement> allCells = row.findElements(By.cssSelector("[role=cell]"));
            Assert.assertTrue(allCells.get(2).getText().contains("ESS"));
        }
    }

    @Test(priority = 3, description = "Search by status")
    public void SearchByStatus() throws InterruptedException {
        adminPageUserManagement = new AdminPage_UserManagement(driver);
        Utils.scrollUp(driver);
        adminPageUserManagement.reset();
        adminPageUserManagement.searchUerBYSTATUS(driver,0);
        Thread.sleep(2000);
        adminPageUserManagement.buttonSearch();
        Thread.sleep(2000);
        WebElement table = driver.findElement(By.className("oxd-table-body"));
        Utils.scrollDownElement(driver,table);
        List<WebElement> allrows = table.findElements(By.cssSelector("[role=row]"));
        System.out.println(allrows.size());
        for (WebElement row: allrows) {
            List<WebElement> allCells = row.findElements(By.cssSelector("[role=cell]"));
            Assert.assertTrue(allCells.get(4).getText().contains("Enable"));
        }
    }

    @Test(priority = 4, description = "Add user")
    public void AddUser() throws InterruptedException {
    adminPageUserManagement = new AdminPage_UserManagement(driver);
    Utils.scrollUp(driver);
    adminPageUserManagement.addUser(driver,0,0, "C", "Admin123","12345678Abc");

    }

//    @Test(priority = 5, description = "Type for hint at Adduser of Admin page")
//    public void typeForHint()
//    {
//        adminPageUserManagement = new AdminPage_UserManagement(driver);
//        adminPageUserManagement.findByHint(driver,"A");
//
//    }

}
