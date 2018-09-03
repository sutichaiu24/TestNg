package com.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RabbitProfilePage {
    private static WebElement element = null;


    public static WebElement fillHome_address(WebDriver driver) {
        element = driver.findElement(By.id("home-address"));
        return element;
    }

    public static WebElement fillHome_village(WebDriver driver) {
        element = driver.findElement(By.id("home-village-building"));
        return element;
    }

    public static WebElement fillSoi(WebDriver driver) {
        element = driver.findElement(By.id("home-soi"));
        return element;
    }

    public static WebElement fillHomeStreet(WebDriver driver) {
        element = driver.findElement(By.id("home-street"));
        return element;
    }

    public static Select selectHomeProvince(WebDriver driver) {
        return new Select(driver.findElement(By.id("home-province")));
    }

    public static Select selectHomeDistrict(WebDriver driver) {
        return new Select(driver.findElement(By.id("home-district")));
    }

    public static WebElement Save(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        element = driver.findElement(By.xpath("//*[@id=\"address\"]/form/div[8]/div/button"));
        return element;
    }

}
