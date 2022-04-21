package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class oanda {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://www.oanda.com/currency-converter/en/?from=EUR&to=USD&amount=1");
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.quit();
    }

    @Test
    public void datenow(){
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String expect = simpleDateFormat.format(new Date());
        String ngayht = this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div/div/input")).getAttribute("value");
        Assert.assertEquals(expect,ngayht);
    }

}
