package com.automation.tests.homework_4;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.Keys.ENTER;

public class AmazonTest2 {
    //1.go to https://amazon.com
    // 2.search for "wooden spoon"
    // 3.click search4.rememberthe nameand the price of a random result
    // 5.click on that random result
    // 6.verify default quantityof items is 1
    // 7.verify that the name and the price is the same as the one from step 5
    // 8.verify button"Add to Cart" is visible
  private WebDriver driver;
  private String url="https://amazon.com";
  //Under $10
    //OXO 1130880 Good Grips Wooden Corner Spoon & Scraper,Brown
    //OXO 1130880 Good Grips Wooden Corner Spoon & Scraper,Brown
    //4.5 out of 5 stars 2,987
    //$5.99

@Test
public void testingTitle() {
    WebDriverWait wait=new WebDriverWait(driver, 20);
    WebElement box=driver.findElement(By.id("twotabsearchtextbox"));
    wait.until(ExpectedConditions.visibilityOfAllElements(box));
    box.sendKeys("wooden spoon",ENTER);
    Random random=new Random();
    List<WebElement> allItems = driver.findElements(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));
    int index=random.nextInt(allItems.size()-1);
//String xpathForRandonItem=
    WebElement spoon= driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])["+index+"]"));
    spoon.click();
    BrowserUtils.wait(2);
    String actualdropdowndefaultvalue=driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]//span[@class='a-dropdown-prompt'] ")).getText();
    BrowserUtils.wait(2);
    // 6.verify default quantityof items is 1
    Assert.assertTrue(actualdropdowndefaultvalue.trim().equals("1"));
    String price=driver.findElement(By.id("price_inside_buybox")).getText();

    BrowserUtils.wait(2);
    String firstPrice=driver.findElement(By.xpath("(//*[@class='a-offscreen'])["+index+"]")).getText();
    BrowserUtils.wait(2);
    String nameProduct=driver.findElement(By.id("productTitle")).getText();
    System.out.println(nameProduct);
    String firstnameProduct=spoon.getText();
    System.out.println(firstPrice+"  "+price);
    System.out.println(firstnameProduct+" * "+nameProduct);

    Assert.assertTrue(price.equals(firstPrice));
    Assert.assertTrue(firstnameProduct.contains(nameProduct));
    // 8. verify button "Add to Cart" is visible
    Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Add to Cart']")).isDisplayed());


}@BeforeMethod
    public void setUp(){



        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}

