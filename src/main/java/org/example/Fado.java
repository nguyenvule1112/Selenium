package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.parser.Element;

public class Fado {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F");
    }

//    @After
//    public void after() throws InterruptedException {
//        Thread.sleep(3000);
//        this.driver.quit();
//    }

    @Test
    public void loginblank(){
        //click login khi chưa điền thông tin
       this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
        // check text vui lòng nhập lại
//        WebElement underemail = driver.findElement(By.cssSelector("span.is-error mz-form-error-label"));
//        String text = underemail.getText();
//        System.out.println("text:"+text);
        //nhập tài khoản hợp lệ
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyenvule1112@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("abc123");
    }
    @Test
    public void saitaikhoan(){
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyenvule345@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("abc123");
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
//        boolean thongbaoloi = driver.findElement(By.xpath("//div[contains(@class,\"my-alert\")]")).isEnabled();
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,\"my-alert\")]"));
        String linkText = element.getText();
        System.out.println(linkText);
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
    public void login(){
        WebElement tbusername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbusername.sendKeys("nguyensenji96@gmail.com");
        WebElement tbpassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbpassword.sendKeys("Abc123");
        this.driver.findElement(By.xpath("//button[text()=\"Đăng nhập\"]")).click();
//        boolean thongbaoloi = driver.findElement(By.xpath("//div[contains(@class,\"my-alert\")]")).isEnabled();
//        WebElement element = driver.findElement(By.xpath("//div[contains(@class,\"my-alert\")]"));
//        String linkText = element.getText();
//        System.out.println(linkText);
    }
}
