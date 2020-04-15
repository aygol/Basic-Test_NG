package com.automation.tests.homework_4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test9To12 {
    private WebDriver driver;
    private String url="https://practice-cybertekschool.herokuapp.com";
    @DataProvider(name ="testData")
    public static Object [] testData(){
        return new Object [] {"404","500","301","200"};
    }
    @Test(dataProvider="testData")
    public void codeStatus(String code){
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode =driver.findElement(By.linkText(code));
        statusCode.click();
        String expectedMessage ="This page returned a "+code+" status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage),"The status code does not exist");

    }@BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
      if (driver!=null){
          driver.quit();
          driver=null;
      }
    }
}
