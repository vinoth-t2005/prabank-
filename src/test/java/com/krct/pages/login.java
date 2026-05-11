package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
    private WebDriver driver;
    private WebDriverWait wait;



    public login(WebDriver driver,WebDriverWait wait){
        this.wait=wait;
        this.driver=driver;
    }

    public void navi(){
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    private final By uname=By.xpath("//input[@name='username']");
    private final By pas=By.xpath("//input[@name='password']");
    private final By btn =By.xpath("//input[@type='submit']");

    public void uname(String name){driver.findElement(uname).sendKeys(name);}
    public void pass(String pass){driver.findElement(pas).sendKeys(pass);}
    public void btn(){driver.findElement(btn).click();}

    public void login(String name, String pass){
        uname(name);
        pass(pass);
        btn();
    }
    private final By logout=By.xpath("//a[@href='logout.htm']");
    public void log(){driver.findElement(logout).click();}
    public void logout(){
        log();
    }





}
