//package com.seleniumexample;
//
//public class Sel {package com.example.tests;
//
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//    public class Page {
//        private WebDriver driver;
//        private String baseUrl;
//        private boolean acceptNextAlert = true;
//        private StringBuffer verificationErrors = new StringBuffer();
//
//        @BeforeClass(alwaysRun = true)
//        public void setUp() throws Exception {
//            driver = new FirefoxDriver();
//            baseUrl = "https://www.katalon.com/";
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
//
//        @Test
//        public void test01Page() throws Exception {
//            driver.get("https://rabbit.co.th/");
//            driver.close();
//            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
//            driver.close();
//            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | undefined | ]]
//            driver.findElement(By.linkText("เข้าสู่ระบบ")).click();
//            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
//            driver.findElement(By.id("login-password")).clear();
//            driver.findElement(By.id("login-password")).sendKeys("z7NQ42kwFn");
//            driver.findElement(By.id("login-username")).clear();
//            driver.findElement(By.id("login-username")).sendKeys("oh@isecthailand.com");
//            driver.findElement(By.id("btn-login")).click();
//            driver.findElement(By.linkText("ข้อมูลของฉัน")).click();
//            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ถึง'])[1]/following::div[5]")).click();
//            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='นามสกุล:'])[1]/following::div[1]")).click();
//            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='xxx-xxx-xxxx'])[1]/following::a[1]")).click();
//            driver.findElement(By.linkText("ที่อยู่")).click();
//            driver.findElement(By.id("home-address")).click();
//            // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=home-address | ]]
//            driver.findElement(By.id("home-address")).clear();
//            driver.findElement(By.id("home-address")).sendKeys("55/353");
//            driver.findElement(By.id("home-village-building")).click();
//            // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=home-village-building | ]]
//            driver.findElement(By.id("home-village-building")).clear();
//            driver.findElement(By.id("home-village-building")).sendKeys("g");
//            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='รหัสไปรษณีย์'])[3]/following::button[1]")).click();
//            driver.findElement(By.linkText("ข้อมูลของฉัน")).click();
//            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='แก้ไข'])[2]/following::li[1]")).click();
//        }
//
//        @AfterClass(alwaysRun = true)
//        public void tearDown() throws Exception {
//            driver.quit();
//            String verificationErrorString = verificationErrors.toString();
//            if (!"".equals(verificationErrorString)) {
//                fail(verificationErrorString);
//            }
//        }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}
//
//}
