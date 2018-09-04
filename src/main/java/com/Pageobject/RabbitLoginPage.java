package com.Pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RabbitLoginPage {

    private  static  WebElement element = null ;

    public static WebElement user_textbox (WebDriver driver)
    {
        element =  driver.findElement(By.id("login-username"));
        return element;
    }
    public static WebElement password_textbox (WebDriver driver)
    {
        element = driver.findElement(By.id("login-password"));
        return  element;
    }
    public static WebElement login_button (WebDriver driver)
    {
        element = driver.findElement(By.id("btn-login"));
        return  element;
    }
    public static WebElement register (WebDriver driver)
    {   JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        element = driver.findElement(By.xpath("//*[@id=\"mainloginform\"]/div[3]/div[4]/div/a"));
        return  element;
    }



}
