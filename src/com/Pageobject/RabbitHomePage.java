package com.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class RabbitHomePage {

    private static WebElement element = null;

    public static WebElement myprofile_link(WebDriver driver) {
        element = driver.findElement(By.linkText("ข้อมูลของฉัน"));
        return element;
    }

    public static WebElement name_arrow(WebDriver driver) {
        element = driver.findElement(By.linkText("sudhichai ungsuthornrungsi"));
        return element;
    }

    public static WebElement Edit_button(WebDriver driver)
    {
        element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='xxx-xxx-xxxx'])[1]/following::a[1]"));
        return element;
    }


}


