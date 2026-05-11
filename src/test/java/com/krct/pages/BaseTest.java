package com.krct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

//import com.krct.pages.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setUp() {


        driver = new ChromeDriver();

        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        System.out.println(config.getBaseUrl());

        driver.get(config.getBaseUrl());


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}