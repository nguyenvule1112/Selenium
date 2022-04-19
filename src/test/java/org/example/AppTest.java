package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    WebDriver driver;
    @Before
    public void Beforetest(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Nguyen\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();//phong to trinh duyet
    }
    @After
    public void Aftertest(){
        this.driver.quit();
    }

    @Test
    public void DemoQA()
    {
        {
            driver.get("https://demoqa.com/swagger/");
        }
    }

    @Test
    public void Getandprinttitle()
    {
        {
            driver.get("https://demoqa.com/swagger/");
            String title = driver.getTitle();
            System.out.println("Page title :" +title);
            System.out.println("Title length:" +title.length());

        }
    }

    @Test
    public void GetpageURL()
    {
        {
            driver.get("https://demoqa.com/swagger/");
            String url = driver.getCurrentUrl();
            String title = driver.getTitle();
            String titleexpect = "Swagger UI";

            Assert.assertEquals(title,titleexpect);
        }
    }

    @Test
    public void GetPagesource()
    {
        {
            driver.get("https://demoqa.com/swagger/");
            String source = driver.getPageSource();
            System.out.println("Source length:" +source.length());

        }
    }
}


