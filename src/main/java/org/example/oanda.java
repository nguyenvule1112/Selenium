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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
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
    public void source_currency(){
        //Webelement
        String currency1 = this.driver.findElement(By.xpath("(//div[contains(@class,\"MuiOutlinedInput-adornedStart\")]/div/div)[1]")).getText();
        String currency2 = this.driver.findElement(By.xpath("(//div[contains(@class,\"MuiOutlinedInput-adornedStart\")]/div/div)[2]")).getText();

        WebElement source1 = this.driver.findElement(By.xpath("(//div[contains(@class,\"MuiAutocomplete-root\")])[1]"));
        source1.click();
        boolean Currencypicker1 = this.driver.findElement(By.cssSelector("div[role=\"presentation\"]")).isDisplayed();
        String currencydefault1 = this.driver.findElement(By.xpath
                ("//li[@id=\"baseCurrency_currency_autocomplete-option-0\"]//span[1]")).getText();

        WebElement source2 = this.driver.findElement(By.xpath("(//div[contains(@class,\"MuiAutocomplete-root\")])[2]"));
        source2.click();
        boolean Currencypicker2 = this.driver.findElement(By.cssSelector("div[role=\"presentation\"]")).isDisplayed();
        String currencydefault2 = this.driver.findElement(By.xpath
                ("//li[@id=\"quoteCurrency_currency_autocomplete-option-0\"]//span[1]")).getText();
        //Assert
        Assert.assertTrue(Currencypicker1);
        Assert.assertTrue(Currencypicker2);
        Assert.assertEquals(currency1,currencydefault1);
        Assert.assertEquals(currency2,currencydefault2);
    }

    @Test
    public void update_exchange_currency() {
        WebDriverWait waiter = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        WebElement getexchangevalue = waiter.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=\"numberformat\"][tabindex=\"4\"]"))) ;

//        WebElement getexchangevalue = this.driver.findElement(By.cssSelector("input[name=\"numberformat\"][tabindex=\"4\"]"));
        String valuebefore = getexchangevalue.getAttribute("value");
        System.out.println(valuebefore);

        WebElement source1 = this.driver.findElement(By.xpath("(//div[contains(@class,\"MuiAutocomplete-root\")])[1]"));
        source1.click();
        WebElement currency1change = this.driver.findElement(By.cssSelector("li#baseCurrency_currency_autocomplete-option-1"));
        currency1change.click();
        String valueafterchange1 = getexchangevalue.getAttribute("value");
        System.out.println(valueafterchange1);

//        WebElement source2 = this.driver.findElement(By.xpath("(//div[contains(@class,\"MuiAutocomplete-root\")])[2]"));
//        source2.click();
//        WebElement currency2change = this.driver.findElement(By.cssSelector("li#quoteCurrency_currency_autocomplete-option-2"));
//        currency2change.click();
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        String valueafterchange2 = getexchangevalue.getAttribute("value");
//        System.out.println(valueafterchange2);
        //Assert
        Assert.assertNotEquals(valuebefore,valueafterchange1);
//        Assert.assertNotEquals(valuebefore,valueafterchange2);
    }
}
