package com.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RabbitRegisterPage {

     private  static  WebElement element = null ;

     public static WebElement user_name (WebDriver driver)
     {
         element =  driver.findElement(By.id("first-name"));
         return  element ;
     }
     public static WebElement last_name (WebDriver driver)
     {
         element = driver.findElement(By.id("last-name"));
         return  element ;
     }
     public static WebElement email_text(WebDriver driver)
     {
         element = driver.findElement(By.id("email"));
         return  element ;
     }
     public static WebElement phone_text(WebDriver driver)
     {
        element = driver.findElement(By.id("phone"));
        return  element ;
     }
     public static WebElement password_text(WebDriver driver)
     {
         element =driver.findElement(By.id("password"));
         return  element;
     }
     public static WebElement confirm_password_text (WebDriver driver)
     {
         element = driver.findElement(By.id("password-confirmation"));
         return  element;
     }
     public static WebElement register_btn (WebDriver driver)
     {
         element = driver.findElement(By.id("reg-submit-btn"));
         return  element;
     }
}
