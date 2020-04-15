package com.automation.tests.homework_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Homework4 {
    protected static WebDriver driver;

    @Test(description = "exit the program After you check and uncheck Friday for the third time")
    public void test1() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        List<WebElement> l1 = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".gwt-CheckBox>input"));
        Random r = new Random();
        int count = 0;
        while (count < 3) {
            // this method will return any value between 0 and 7
            int index = r.nextInt(l1.size());
            if (checkboxes.get(index).isEnabled()) {
                l1.get(index).click();
                if (l1.get(index).getText().equals("Friday")) {
                    count++;
                }
                System.out.println(l1.get(index).getText());
                l1.get(index).click();
            }
        }
    }

    @Test(description = "Verifying today date")
    public void todays_date() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);
        String year_value = y.getFirstSelectedOption().getText();
        String month_value = m.getFirstSelectedOption().getText();
        String day_value = d.getFirstSelectedOption().getText();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");
        Assert.assertEquals(year_value + month_value + day_value, sf.format(new Date()));
    }

    @Test(description = "if you randomly select a leap year, verify February has 29 days")
    public void years_months_days() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);
        Random r = new Random();
        List<WebElement> years = y.getOptions();
        List<WebElement> months = m.getOptions();
        int index = r.nextInt(years.size());
        y.selectByIndex(index);


        if (Year.isLeap(Integer.parseInt(years.get(index).getText())) && (months.get(index).getText() == "February")) {
            Assert.assertTrue(29 == d.getOptions().size());


        }
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
