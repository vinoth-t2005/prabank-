package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AccountOverview extends BaseTest{

    @DataProvider
    public Object[][] regis() {
        return new Object[][]{
                {"vinoth", "T", "ABC", "NEWYORK", "CANADA", "7324656", "1234567891", "123456", "vinoth01", "vinoth2005", "vinoth2005"}

        };
    }

    @DataProvider
    public Object[][] login(){
        return new Object[][]{
                {"vinoth01","vinoth2005"}

        };
    }
    @Test(priority = 1, dataProvider = "regis" )
    public void RegisterTest(String fname,String lname, String add, String city, String state, String zip, String ph, String ssn, String uname,String pass, String cpass){
        register regi=new register(driver,wait);
        regi.reg(fname, lname, add, city, state, city, state, zip, ph, ssn, uname, pass, cpass );
        WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));
        String ms=msg.getText();
        Assert.assertTrue(ms.contains("Welcome"));
    }


    @Test(priority = 2, dataProvider = "login")
    public void overview(String name,String pass){
        login log=new login(driver,wait);

        log.login(name,pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.htm']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='overview.htm']"))).click();
        WebElement acc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='accountTable']//a")));

        String msg = acc.getText();
        Assert.assertFalse(msg.isEmpty());
    }

    @Test(priority = 3, dataProvider = "login")
    public void acc(String name,String pass){
        login log=new login(driver,wait);

        log.login(name,pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.htm']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='overview.htm']"))).click();
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='accountTable']/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if(cols.size() >= 0) {
                String accno = cols.get(0).getText();
                String bal = cols.get(1).getText();
                Assert.assertFalse(accno.isEmpty());
                Assert.assertFalse(bal.isEmpty());
            }
        }
    }


    @Test(priority = 4, dataProvider = "login")
    public void activitydetails(String name,String pass){
        login log=new login(driver,wait);

        log.login(name,pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.htm']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='overview.htm']"))).click();
        WebElement acc = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//a[contains(@href,'activity.htm')]")));

        acc.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountId")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountId")));
    }

    @Test(priority = 5, dataProvider = "login")
    public void navigate(String name,String pass){
        login log=new login(driver,wait);

        log.login(name,pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.htm']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='overview.htm']"))).click();
        WebElement acc = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//a[contains(@href,'activity.htm')]")));

        acc.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountId")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountId")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='overview.htm']"))).click();
        String str=driver.findElement(By.xpath("//h1[@class='title']")).getText();
        Assert.assertEquals(str,"Accounts Overview");
    }
}




