package com.seleniumexample;

import com.Pageobject.RabbitHomePage;
import com.Pageobject.RabbitLoginPage;
import com.Pageobject.RabbitProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


import static org.testng.Assert.*;
import static java.lang.Thread.*;

public class RabbitRegistration {
    public static WebDriver driver = null;
    private String baseUrl;
    private String email;
    private String password;
    private String homeAddress;
    private String home_soi;
    private String homevillage;
    private String home_street;
    private String home_province;
    private String home_district;
    private Thread thread;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://id.rabbit.co.th/login";
        email = "oh@isecthailand.com";
        password = "z7NQ42kwFn";
        homeAddress = "55/353";
        homevillage = "Muangthongthanee";
        home_soi = "5";
        home_street = "Jangwattana";
        home_province = "นนทบุรี";
        home_district = "ปากเกร็ด";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Test01_RegistrationPage_Completed() throws Exception {
        Login();
        GotoMyProfile();
        Edit();
        FillTheAddress();
    }

    private void FillTheAddress() throws InterruptedException {
        thread.sleep(2000);

        RabbitProfilePage.fillHome_address(driver).clear();
        RabbitProfilePage.fillHome_address(driver).sendKeys(homeAddress);

        RabbitProfilePage.fillHome_village(driver).clear();
        RabbitProfilePage.fillHome_village(driver).sendKeys(homevillage);

        RabbitProfilePage.fillSoi(driver).clear();
        RabbitProfilePage.fillSoi(driver).sendKeys(home_soi);

        RabbitProfilePage.fillHomeStreet(driver).clear();
        RabbitProfilePage.fillHomeStreet(driver).sendKeys(home_street);

        RabbitProfilePage.selectHomeProvince(driver).selectByVisibleText(home_province);
        RabbitProfilePage.selectHomeDistrict(driver).selectByVisibleText(home_district);

        RabbitProfilePage.Save(driver).click();

        String expectedText ="ข้อมูลถูกอัพเดตแล้ว!";
        WebElement msg=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div[1]"));
        String text=msg.getText();
        Assert.assertEquals(text,expectedText);
    }

    private void Edit() {
        RabbitHomePage.Edit_button(driver).click();
        RabbitHomePage.Edit_address(driver).click();
    }

    private void GotoMyProfile() {
        RabbitHomePage.name_arrow(driver).click();
        RabbitHomePage.myprofile_link(driver).click();
    }

    private void Login() throws InterruptedException {

        driver.get(baseUrl);
        RabbitLoginPage.user_textbox(driver).clear();
        RabbitLoginPage.user_textbox(driver).sendKeys(email);
        RabbitLoginPage.password_textbox(driver).clear();
        RabbitLoginPage.password_textbox(driver).sendKeys(password);
        RabbitLoginPage.login_button(driver).click();
    }
}
