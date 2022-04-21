package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import javax.swing.text.html.parser.Element;
import java.awt.*;

public class Fado {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F");
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.quit();
    }

    @Test
    public void loginblank() {
        //click login khi chưa điền thông tin
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
        // check text vui lòng nhập lại tại fields email
        WebElement blank = driver.findElement(By.id("auth-block__form-group__email-error"));
        String textblank = blank.getText();
        String expect = "Vui lòng nhập dữ liệu";
        Assert.assertEquals(expect, textblank);
        //lấy màu text và convert to hex
        String colortext = blank.getCssValue("color");
        String colorhex = Color.fromString(colortext).asHex();
        String colorExpect = "#cc353b";
        Assert.assertEquals(colorhex, colorExpect);
        //lấy màu border email
        WebElement border = driver.findElement(By.id("auth-block__form-group__email"));
        String colorborder = border.getCssValue("border-color");
        String colorbdhex = Color.fromString(colorborder).asHex();
        String colorbdExpect = "#cc353b";
        Assert.assertEquals(colorbdhex, colorbdExpect);

        //password
        // check text vui lòng nhập lại tại fields password
        WebElement blankpw = driver.findElement(By.id("password-error"));
        String textblankpw = blankpw.getText();
        String expectpw = "Vui lòng nhập dữ liệu";
        Assert.assertEquals(expectpw, textblankpw);
        //lấy màu text và convert to hex
        String colortextpw = blank.getCssValue("color");
        String colorhexpw = Color.fromString(colortextpw).asHex();
        String colorExpectpw = "#cc353b";
        Assert.assertEquals(colorhexpw, colorExpectpw);
        //lấy màu border email
        WebElement borderpw = driver.findElement(By.xpath("//*[@id=\"auth-block__login-form\"]/div[2]/div[2]/div/input"));
        String colorborderpw = borderpw.getCssValue("border-color");
        String colorbdhexpw = Color.fromString(colorborderpw).asHex();
        String colorbdExpectpw = "#cc353b";
        Assert.assertEquals(colorbdhexpw, colorbdExpectpw);
    }
    @Test
        public void tkhople() {
        //click login khi chưa điền thông tin
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
        //nhập tài khoản hợp lệ
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyenvule1112@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("abc123");
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();

        // check text vui lòng nhập lại tại fields email
        WebElement blank = driver.findElement(By.id("auth-block__form-group__email-error"));
        boolean textblank = blank.isDisplayed();
        Assert.assertFalse(textblank);
        //lấy màu border email
        WebElement border = driver.findElement(By.id("auth-block__form-group__email"));
        String colorborder = border.getCssValue("border-color");
        String colorbdhex = Color.fromString(colorborder).asHex();
        String colorbdExpect = "#e1e1e1";
        Assert.assertEquals(colorbdhex, colorbdExpect);

         //password
        // check text vui lòng nhập lại tại fields password
        WebElement blankpw = driver.findElement(By.id("password-error"));
        boolean textblankpw = blankpw.isDisplayed();
        Assert.assertFalse(textblankpw);
        //lấy màu border email
        WebElement borderpw = driver.findElement(By.xpath("//*[@id=\"auth-block__login-form\"]/div[2]/div[2]/div/input"));
        String colorborderpw = borderpw.getCssValue("border-color");
        String colorbdhexpw = Color.fromString(colorborderpw).asHex();
        String colorbdExpectpw = "#e1e1e1";
        Assert.assertEquals(colorbdhexpw, colorbdExpectpw);
    }
    @Test
    public void saitaikhoan() throws InterruptedException {
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyenvule11245@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("abc123");
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
        WebElement t =  this.driver.findElement(By.xpath("//div[contains(@class, \"my-alert -alert-danger\")]"));
        String text= t.getText();
        System.out.println(text);
//        boolean thongbaoloi = t.isEnabled();
//        Assert.assertFalse(thongbaoloi);
//        String expectthongbaoloi = "- Tài khoản không tồn tại, vui lòng kiểm tra lại";
//

    }
    @Test
    public void saipassword(){
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyenvule1112@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("abc123");
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
//        boolean thongbaoloi = driver.findElement(By.xpath("//div[contains(@class,\"my-alert\")]")).isEnabled();
//        WebElement element = driver.findElement(By.xpath("//div[contains(@class,\"my-alert\")]"));
//        String linkText = element.getText();
//        System.out.println(linkText);
    }

    @Test
    public void login() throws InterruptedException {
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyensenji96@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("Abc123");
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
        Thread.sleep(3000);
        String checkusername = this.driver.findElement(By.cssSelector("span.user-name-col")).getText();
        String expectusername = "Nguyên Vũ Lê";
    }
}
