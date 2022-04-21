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

import java.text.SimpleDateFormat;
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

     public boolean getButtonStatus() {
         return this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div/div/div[2]/button[1]")).isEnabled();
     }

    @Test
    public void datenow() throws InterruptedException {
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String expect = simpleDateFormat.format(new Date());
        String ngayht = this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div/div/input")).getAttribute("value");
        Assert.assertEquals(expect,ngayht);
        boolean buttonnext = this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div/div/div[2]/button[1]")).isEnabled();
        Assert.assertFalse(this.getButtonStatus());

        //enable khi ngày quá khứ.
        this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div/div/div[1]/button")).click();
        Assert.assertTrue(this.getButtonStatus());

        //datepicker enable
        boolean datepicker= this.driver.findElement(By.cssSelector("div.react-datepicker")).isEnabled();
        Assert.assertTrue(datepicker);
    }

    @Test
    public void pickdate (){
        this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div")).click();
        WebElement pickday = this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[3]/div/div/div[2]/div[2]/div[2]/div[3]"));
        String daychoose = pickday.getText();
        pickday.click();
        System.out.println(daychoose);
        String newday = this.driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[2]/div/div/input")).getText();

    }


}
