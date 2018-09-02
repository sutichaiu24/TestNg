package com.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RabbitProfilePage {
    private static WebElement element = null;

    public static WebElement Leftpanel_address (WebDriver driver)
    {
        element = driver.findElement(By.linkText("ที่อยู่"));
        return element;
    }

    public static WebElement fillhome_address (WebDriver driver )
    {
        element = driver.findElement(By.id("home-address"));
        return  element;
    }
    public void setHomeAddress (WebDriver driver)
    {
        element = driver.findElement(By.id("home_village_building"));
        return element ;
    }



    @FindBy(id ="home-village-building")
    WebElement home_village_building ;

    @FindBy(id ="home-soi")
    WebElement home_soi;

    @FindBy(id ="home-street")
    WebElement home_street ;


    public void setHomeVillage (String homevillage)
    {
        home_village_building.sendKeys(homevillage);
    }
    public void setHom
}
