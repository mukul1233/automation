package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class test extends base {
    WebElement bookDemoButton;
    WebElement emailInput;
    WebElement submitEmail;
    WebElement demoText;
    WebElement chatFrame;
    WebElement emailID;

    @Test

    public void buildingTestMethod() {

        String verifyBrowserStackTitle = driver.getTitle();
        assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
        assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);

    }

    @Test
    public void bookDemo() throws InterruptedException {
        bookDemoButton= driver.findElement(By.cssSelector("div.btn-text"));
        bookDemoButton.click();

        emailInput=driver.findElement(By.xpath("(//input[@id='demo-fc-email'])[1]"));
        emailInput.sendKeys("abc@xyz.com");
        submitEmail=driver.findElement(By.xpath("(//input[@id='demo-fc-submit'])[1]"));
        submitEmail.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#fc_widget")));
        demoText= driver.findElement(By.cssSelector("div.h-message-text"));
        Assert.assertTrue(demoText.isDisplayed());
        driver.switchTo().parentFrame();
    }

    @Test
    public void takeScreenShot() throws IOException {

        driver.navigate().to("https://demo.guru99.com/");
        emailID= driver.findElement(By.xpath("//input[@name='emailid']"));
        emailID.sendKeys("milei.cjaihan@gmail.com", Keys.ENTER);
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
        File file= new File("C:\\Users\\mukul\\Downloads\\abc.jpg");
        try {
            Files.copy(srcFile.toPath(),file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkConnection() throws IOException {
        HttpURLConnection huc=null;
        String url="https://google.com";
        huc =(HttpURLConnection) (new URL(url).openConnection());
        huc.setRequestMethod("GET");
        huc.connect();
        System.out.println(huc.getResponseCode()+"\n"+huc.getResponseMessage());
    }
    }

