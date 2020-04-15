package com.automation.tests.homework_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class UnderstandingWaiting {

private WebDriver driver;



    @BeforeMethod
    public void setUp(){



        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }




    @Test
    public void test2(){
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("user1");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Actions a1 = new Actions(driver);
        a1.moveToElement(driver.findElement(By.xpath("(//a/span)[12]"))).pause(1000)
                .moveToElement(driver.findElement(By.xpath("//a[@href='/calendar/event']/span"))).pause(1000)
                .click().build().perform();

//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"))));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"))));

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)).
                        pollingEvery(Duration.ofMillis(500)).
                        ignoring(NoSuchElementException.class).
                        ignoring(ElementClickInterceptedException.class);

//        wait.ignoring(ElementClickInterceptedException.class).ignoring(ElementClickInterceptedException.class)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title=\"Create Calendar event\"]")));
//        wait.ignoring(ElementClickInterceptedException.class)
//                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title=\"Create Calendar event\"]"))));
        WebElement create2 = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement create = driver.findElement(By.xpath("//a[@title=\"Create Calendar event\"]"));

                if(create.isDisplayed()&&create.isEnabled()){
                    return create;
                } else {
                    System.out.println("create button is not available yet");
                    return null;
                }
            }
        });
        //WebElement create = wait.until(driver -> driver.findElement(By.xpath("//a[@title=\"Create Calendar event\"]")));
        create2.click();
    }

}
