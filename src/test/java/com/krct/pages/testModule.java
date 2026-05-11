package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testModule extends BaseTest {

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

    @DataProvider
    public Object[][] loginin(){
        return new Object[][]{
                {"vinoth01","vinoth2000"},
                {"vinoth","vinoth2005"}

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
    public void LoginTest(String name,String pass){
        login log=new login(driver,wait);

        log.login(name,pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.htm']")));
        }


        @Test(priority = 3, dataProvider = "loginin")
    public void LogininvalidTest(String name,String pass){
        login log=new login(driver,wait);

        log.login(name,pass);
            WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));
            String ms=msg.getText();
            Assert.assertTrue(ms.contains("Error"));
    }

    @Test(priority = 4, dataProvider = "login")
    public void LogoutTest(String name,String pass){
        login log=new login(driver,wait);
        log.login(name,pass);
        log.logout();
        WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
    }


}
