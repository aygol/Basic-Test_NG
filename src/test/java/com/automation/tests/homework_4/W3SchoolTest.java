package com.automation.tests.homework_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class W3SchoolTest {
    private WebDriver driver;

    //1.go to https://www.w3schools.com/
    // 2.find all the elements in the page with the tag a
    // 3.for each of those elements,
    // if it is displayed on the page, print the text and the href of that element.
    @Test
    public void pageWithTag() {
        driver.get("https://www.w3schools.com/");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement each : list) {
            if (each.isDisplayed()) {
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }

    }@Test
    public void valid_links(){
        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for(int i=0;i<list.size();i++){
            String href=list.get(i).getAttribute("href");
            try{
                URL url=new URL(href);
                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();
                Assert.assertEquals(httpURLConnection.getResponseCode(),200);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("81").setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}


