package com.Pag;
import com.Pageobject.RabbitHomePage;
import com.Pageobject.RabbitLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static java.lang.Thread.*;

public class RabbitRegistration {
       public static WebDriver driver = null ;
       private String baseUrl ;
       private String email;
       private String password;

    @BeforeClass
    public void setUp() throws Exception {
           driver = new ChromeDriver();
           baseUrl = "https://id.rabbit.co.th/login";
           email = "oh@isecthailand.com";
           password = "z7NQ42kwFn";
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       }

    @Test
    public void  Test01_RegistrationPage ()throws Exception {

        try {
            Login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GotoMyProfile() ;
        Edit();
        FillTheAddress();
       }

    private void FillTheAddress() {

    }

    private void Edit() {
        RabbitHomePage.Edit_button(driver).click();
    }

    private  void GotoMyProfile() {
        RabbitHomePage.name_arrow(driver).click();
        RabbitHomePage.myprofile_link(driver).click();

    }

    private void Login () throws InterruptedException {

          driver.get(baseUrl);
          RabbitLoginPage.user_textbox(driver).clear();
          RabbitLoginPage.user_textbox(driver).sendKeys(email);
          RabbitLoginPage.password_textbox(driver).clear();
          RabbitLoginPage.password_textbox(driver).sendKeys(password);
          RabbitLoginPage.login_button(driver).click();
      }
}
