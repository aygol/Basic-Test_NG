package com.automation.tests;

import com.automation.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class VY_Track_Practice {
    private WebDriver driver;
    private String url="https://qa3.vytrack.com/user/login";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By clickLogin=By.id("_submit");
    @BeforeMethod
    protected void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    protected void login(){
        driver.get(url);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(clickLogin).submit();
    }
    @Test
    protected void createContact(){
        login();
        WebElement contactLink=driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contactLink.click();
        BrowserUtils.wait(5);
        WebElement creatingContact=driver.findElement(By.linkText("Create Contact"));
        creatingContact.click();
        String currentTitle=driver.getTitle();
        Assert.assertEquals(currentTitle,"Create Contact - Contacts - Customers");
        HashMap<String,String> contact1= new HashMap<>();
        contact1.put("First Name","John");
        contact1.put("Phone","954-234-1234");
        contact1.put("Street","400 Main Street");
        contact1.put("City","Tysons");
        contact1.put("State","VA");
        contact1.put("Sales Group","true");
        contact1.put("Country","United States");
        System.out.println("Contact 1: "+contact1);
    }
}

