//package test;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//
//public class base {
//    WebDriver driver;
//
//    @BeforeTest
//    public void initDriver(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mukul\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.navigate().to("https://www.browserstack.com/");
//        driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
//    }
//
//    @AfterTest
//    public void closeBrowser(){
//        driver.quit();
//    }
//
//}