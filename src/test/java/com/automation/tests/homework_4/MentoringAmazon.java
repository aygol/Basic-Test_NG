package com.automation.tests.homework_4;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MentoringAmazon {
  private WebDriver driver;
   @Test
public void cart(){
       String url="https://amazon.com";
       WebElement box=driver.findElement(By.id("twotabsearchtextbox"));

   }




    @BeforeMethod
public void setUp(){



    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

}
    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
