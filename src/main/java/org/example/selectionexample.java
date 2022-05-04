package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class selectionexample {
    WebDriver driver;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }
    @Test
    public void Working_with_selection(){
        this.driver.get("https://www.facebook.com");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement btnsignup = this.driver.findElement(
                By.cssSelector("a[data-testid=\"open-registration-form-button\"]"));
        btnsignup.click();

        WebDriverWait waitpopup = new WebDriverWait(this.driver,Duration.ofSeconds(15));
        WebElement signupform = waitpopup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#reg_box")));

        // Các bước làm việc (lựa chọn giá trị) trên selection box
        // step1 : tạo 1 web element tới thẻ select
        WebElement elyeah = signupform.findElement(By.cssSelector("select[name=\"birthday_year\"]"));
        // Step2 : chuyển element select sang đối tượng select
        Select cboYeah = new Select(elyeah);
        //step 3: sử dụng các method của đối tượng selection chọn option mình muốn
        cboYeah.selectByValue("1986");
        //selectbyvalue : truyền giá trị của thuộc tính valaue của element option mà mình muốn chọn
        // selectbyindex : chọn theo thứ tự các option (index luôn bắt đầu từ 0)
        // selectbyvisibletext: chọn theo text (inner text) hiển thị trên element

        WebElement elMonth = signupform.findElement(By.cssSelector("select#month"));
        Select cboMonth = new Select(elMonth);
        cboMonth.selectByVisibleText("Nov");
    }

    @Test
    public void fake_selection(){
        this.driver.get("https://dev.vn.euroland.com/tools/currencyconverter");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement toCurrency = this.driver.findElement(By.xpath("//inout[@name=\"CurrencyTo\"]/../div"));
        toCurrency.click();

        WebElement vnCurrency = this.driver.findElement(By.cssSelector("div=[title=\"Vietnamese dong\"]"));
        Actions mouseaction = new Actions(this.driver);
        mouseaction
    }
}
