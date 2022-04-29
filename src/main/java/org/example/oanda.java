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
         return this.driver.findElement(By.cssSelector("div.MuiInputAdornment-positionEnd button[class*=\"cc33\"]")).isEnabled();
     }

    @Test
    public void check_datenow_and_check_next_button() throws InterruptedException {
        //webb element
        WebElement pickdate = this.driver.findElement(By.cssSelector("div.react-datepicker__input-container input"));
        WebElement buttonnext = this.driver.findElement(By.cssSelector("div.MuiInputAdornment-positionEnd button[class*=\"cc33\"]"));
        WebElement buttonback = this.driver.findElement(By.cssSelector("div.MuiInputAdornment-positionStart button[class*=\"cc33\"]"));
        // get value to check
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String expectdatenow = simpleDateFormat.format(new Date());
        String actualdatenow = pickdate.getAttribute("value");
        boolean actualnextbutton1 = buttonnext.isEnabled();

        buttonback.click();
        WebElement datepicker= this.driver.findElement(By.cssSelector("div.react-datepicker"));
        boolean actualnextbutton2= buttonnext.isEnabled();
        boolean datepickerenable = datepicker.isDisplayed();


        //Assert
        Assert.assertEquals(expectdatenow,actualdatenow);
        Assert.assertFalse(actualnextbutton1);
        Assert.assertTrue(actualnextbutton2);
        Assert.assertTrue(datepickerenable);

    }

    @Test
    public void pickdate (){
        //Webelement
        WebElement pickdate = this.driver.findElement(By.cssSelector("div.react-datepicker__input-container input"));
        pickdate.click();
        WebElement pickday = this.driver.findElement(By.cssSelector("div.react-datepicker__week div[class*=\"react-datepicker__day--020\"]"));

        //get value
        String daychoose = pickday.getText();
        pickday.click();
        String actualdate = pickdate.getAttribute("value");
        String[] displayday = actualdate.split(" ");

       //Khai báo pattern DD MMMM YYYY
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String expectdatechoose = simpleDateFormat.format(new Date("04/20/2022"));

        //Assert
        Assert.assertEquals(displayday[0],daychoose);
        Assert.assertEquals(expectdatechoose,actualdate);
    }

    @Test
    public void source_cureny(){
        //Webelement
        WebElement source1 = this.driver.findElement(By.xpath("(//div[contains(@class, \"MuiAutocomplete-root\")])[1]"));
    }

}
