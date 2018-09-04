package com.seleniumexample;

import com.Pageobject.RabbitHomePage;
import com.Pageobject.RabbitLoginPage;
import com.Pageobject.RabbitProfilePage;
import com.Pageobject.RabbitRegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
    private final static String expectedupdateText ="ข้อมูลถูกอัพเดตแล้ว!";
    private  Thread thread;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://id.rabbit.co.th/login";
        email = "oh@isecthailand.com";
        password = "z7NQ42kwFn";
        homeAddress = "55/777";
        homevillage = "Chatmanee";
        home_soi = "5";
        home_street = "Jangwattana";
        home_province = "นนทบุรี";
        home_district = "ปากเกร็ด";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void Test01_Registration () throws InterruptedException {
        Register(email);
        Login(email,password);
        Logout();
    }
    @Test
    public void Test02_UpdateAddress_Completed() throws Exception {
        Login(email,password);
        GotoMyProfile();
        Edit();
        FillTheAddress();
        VerifyAddressFromMyProfile();
    }

    private void VerifyAddressFromMyProfile() throws InterruptedException {
        RabbitHomePage.myprofile_link(driver).click();
        thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(".//*[@id=\"my-details\"]/ul[2]/li[1]"));
        String text=element.getText();
        String addressExpect = String.format("ที่อยู่อาศัย %s, %s, %s, %s, %s, %s, %s",homeAddress,homevillage,home_soi,home_street,home_district,home_district,home_province);
        Assert.assertEquals(text,addressExpect);
    }
    private void Register(String email) throws  InterruptedException {
        driver.get(baseUrl);
        RabbitLoginPage.register(driver).click();
        RabbitRegisterPage.user_name(driver).sendKeys("sudhichai");
        RabbitRegisterPage.last_name(driver).sendKeys("ungsuthornrungsi");
        RabbitRegisterPage.email_text(driver).sendKeys(email);
        RabbitRegisterPage.phone_text(driver).sendKeys("0921546778");
        RabbitRegisterPage.password_text(driver).sendKeys(password);
        RabbitRegisterPage.confirm_password_text(driver).sendKeys(password);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        RabbitRegisterPage.register_btn(driver).click();
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


        WebElement msg=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div[1]"));
        String text=msg.getText();
        Assert.assertEquals(text,expectedupdateText);
    }

    private void Edit() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        RabbitHomePage.Edit_button(driver).click();
        RabbitHomePage.Edit_address(driver).click();
    }

    private void GotoMyProfile() {
        RabbitHomePage.name_arrow(driver).click();
        RabbitHomePage.myprofile_link(driver).click();
    }


    private void Login(String user ,String password) throws InterruptedException {
        driver.get(baseUrl);
        RabbitLoginPage.user_textbox(driver).clear();
        RabbitLoginPage.user_textbox(driver).sendKeys(user);
        RabbitLoginPage.password_textbox(driver).clear();
        RabbitLoginPage.password_textbox(driver).sendKeys(password);
        RabbitLoginPage.login_button(driver).click();
    }

    private void Logout () throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"sub-navbar\"]/ul/li[4]/a/span"));
        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.linkText("ออกจากระบบ"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

    }
}
