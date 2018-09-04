package com.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class RabbitHomePage {

    private static WebElement element = null;

    public static WebElement myprofile_link(WebDriver driver) {
        element = driver.findElement(By.linkText("ข้อมูลของฉัน"));
        return element;
    }

    public static WebElement arrow(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"sub-navbar\"]/ul/li[4]/a/span"));
        return element;
    }

    public static WebElement name_arrow(WebDriver driver) {
        element = driver.findElement(By.linkText("sudhichai ungsuthornrungsi"));
        return element;
    }

    public static WebElement logout_arrow(WebDriver driver) {
        element = driver.findElement(By.linkText("ออกจากระบบ"));
        return element;
    }

    public static WebElement Edit_button(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        element = driver.findElement(By.xpath("(//a[contains(text(),'แก้ไข')])[2]"));
        return element;
    }

    public static WebElement Edit_address(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"address-tab\"]/a"));
        return element;
    }


}


