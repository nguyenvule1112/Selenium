//package org.example;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class CellphoneSlocator {
//    WebDriver driver;
//
//    @Before
//    public void initTest(){
//        //khai baso webdrive o cho nao.
//        //làm tự động ? - thư viện webdrivemanager.
//        WebDriverManager.chromedriver().setup();//tự động tải webdriver phù hợp
//        this.driver  = new ChromeDriver();
//        this.driver.manage().window().maximize();
//
//        }
//
//    @After
//    public void afer(){
//        this.driver.quit();
//    }
//
//    @Test
//    public void Test() throws InterruptedException {
//        this.driver.get("https://cellphones.com.vn/");
////        nhập iphone 12 vào keyword -> enter để tìm kiếm
////        WebElement tbSearch = this.driver.findElement(By.id("search"));
////        WebElement tbSearch = this.driver.findElement(By.name("q"));
////        WebElement tbSearch this.driver.findElement(By.className("cps-input cta-search"));
////        tbSearch.sendKeys("Iphone12");
////        tbSearch.sendKeys(Keys.ENTER);
//        ((JavascriptExecutor)this.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)") ;
////        Thread.sleep(2000);
////        this.driver.findElement(By.className("btn-back-to-top")).click();
//        this.driver.findElement(By.linkText("Tuyển dụng")).click();
//    }
//
//    @Test
//    public void Test_CSSLocator(){
//        //locator phức tạp (k dùng đc với các locator theo attribute của html (id,name,classname,linktext)
//        //từ 2 dấu hiệu trở lên
//        //2 loại locator hỗ trợ:csslocator,xPath
//        //CSS locator:
//        //tag+id cú pháp : tagname#id_value vidu :input#email
//        //tag+ class value : tagname.
//        // tag+ attribute
//        //combine > 2 giá trị
//
//
//        //kết hợp 2 biểu thức locator với nhau:viết 2 biểu thức locator sau đó
//        // dùng quan hệ của thằng con với thằng cha để xác định đến element mình muốn
//        //absolute: trong HT không xác định đc đến Element mình muốn nhưng lại xác định đc đến
//        //element cha thì dùng quy tắc <parent locator> >  < child locator>. ví dụ: div.mod_input-loginname>input
//        //relative div.mod_input-loginname input (con gián tiếp)
//     }
//    @Test
//    public void Test1(){
//        this.driver.get("");
//        WebElement tbUsername = this.driver.findElement(By.cssSelector());
//    }
//
//    //xPath
//    public void Test_xPathLocator(){
//         /* xpath(path-đường dẫn).là 1 quy tắc xác định đến các element dựa vào path trong tài liệu XML
//         xPath sử dụng / -cho đường dẫn tuyệt đối.(absilute path)
//        ví dụ:  /html/body/script
//        sử dụng khi mình muốn 1 quy tắc quan hệ chặt chẽ giữa các element ,phải theo đúng thứ tự trong biểu thức.
//         xPath sử dụng // - cho đường dẫn tương đối (relative path)
//         ví dụ : //div
//         sử dụng khi không cần biết quan hệ giữa element này với element chứa nó.
//
//         có thể sử dụng attribute kết hợp tag để xác định trong các path
//         //div[@id="itme" - xác định đến element div có thuộc tính id -"itme"
//
//         Ngoài sử dụng thuộc tính trong các path có thể sử dụng các method trong biểu thức xpath
//         text() lấy inner text hiển thị trong element.
//         ví dụ: tham chiếu đến thẻ button có text hiển thị là login
//         //button[text()="Login" or text()="Đăng nhập"] -xác định đến các button có text là login hoặc đăng nhập.
//
//         contain(attribut, value) lấy các element có giá trị của thuộc tính attribute chứa value
//         ví dụ: //button[contains(@class, "next-btn-primary")]
//
//          */
//    }
//}
