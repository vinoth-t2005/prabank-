package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class register {
    private WebDriver driver;
    private WebDriverWait wait;




    public register(WebDriver driver,WebDriverWait wait){
        this.wait=wait;
        this.driver=driver;
    }
    private final By regbt=By.linkText("Register");
    private final By fname=By.xpath("//input[@id='customer.firstName']");
    private final By lname=By.xpath("//input[@id='customer.lastName']");
    private final By ad=By.xpath("//input[@id='customer.address.street']");
    private final By cit=By.xpath("//input[@id='customer.address.city']");
    private final By stat=By.xpath("//input[@id='customer.address.state']");
    private final By zipc=By.xpath("//input[@id='customer.address.zipCode']");
    private final By phn=By.xpath("//input[@id='customer.phoneNumber']");
    private final By sn=By.xpath("//input[@id='customer.ssn']");

    private final By unam=By.xpath("//table[@class='form2']//input[@id='customer.username']");
    private final By pas=By.xpath("//table[@class='form2']//input[@id='customer.password']");
    private final By cpas=By.xpath("//table[@class='form2']//input[@id='repeatedPassword']");
    private final By btn=By.xpath("//table[@class='form2']//input[@class='button']");


    public void regbt(){wait.until(ExpectedConditions.visibilityOfElementLocated(regbt)).click();}
    public void fname(String name){driver.findElement(fname).sendKeys(name);}
    public void lname(String name){driver.findElement(lname).sendKeys(name);}
    public void add(String add){driver.findElement(ad).sendKeys(add);}
    public void city(String city){driver.findElement(cit).sendKeys(city);}
    public void state(String state){driver.findElement(stat).sendKeys(state);}
    public void zip(String zip){driver.findElement(zipc).sendKeys(zip);}
    public void ph(String ph){driver.findElement(phn).sendKeys(ph);}
    public void ssn(String ssn){driver.findElement(sn).sendKeys(ssn);}
    public void uname(String name){driver.findElement(unam).sendKeys(name);}
    public void pass(String pass){driver.findElement(pas).sendKeys(pass);}
    public void cpass(String cpass){driver.findElement(cpas).sendKeys(cpass);}
    public void btn(){driver.findElement(btn).click();}

    public void reg(String string, String s, String fname, String lname, String add, String city, String state, String zip, String ph, String ssn, String uname, String pass, String cpass){
        regbt();
        fname(fname);
        lname(lname);
        add(add);
        city(city);
        state(state);
        zip(zip);
        ph(ph);
        ssn(ssn);
        uname(uname);
        pass(pass);
        cpass(cpass);
        btn();
    }





}
