package com.automation.tests.homework_4;


import com.automation.utilities.BrowserUtils;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class TestingAmazon1 {
    private WebDriver driver;


    @Test
    public void verifyingdropDown() {
//go to https://www.amazon.com
// 2.verify that defaultvalue of the All departmentsdropdown is All
////span[text()='All']

        String url = " https://www.amazon.com";
        driver.get(url);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement dropdown = driver.findElement(xpath("//span[text()='All']"));
        String actual = dropdown.getText();
        Assert.assertEquals(actual, "All");


    }

    @Test
    public void verifyingDropdownIsNotSorted() {
        String url = " https://www.amazon.com";
        driver.get(url);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> searchElement = dropdown.getOptions();
        List<String> searchValues = new ArrayList<>();
        for (WebElement each : searchElement) {
            searchValues.add(each.getText());
        }
        for (int i = 0; i < searchValues.size() - 1; i++) {
            if (searchValues.get(i).charAt(0) < searchValues.get(i + 1).charAt(0)) {
                Assert.assertTrue(searchValues.get(i).charAt(0) <= searchValues.get(i + 1).charAt(0), "it is sorted");
                //boolean alphabetiacel=searchValues.get(i).compareTo(searchValues.get(i+1)) >0;

            } else {
                System.out.println("it is not sorted");
            }

        }
    }

    //verify that options in the All departmentsdropdownare not sorted alphabetically


    @Test
    public void main_departments() {
        driver.get("https://www.amazon.com/gp/site-directory");
        List<WebElement> mainDep = driver.findElements(By.tagName("h2"));
        List<WebElement> allDep = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        Set<String> mainDepS = new HashSet<>();
        Set<String> allDepS = new HashSet<>();
        for (WebElement each : mainDep) {
            mainDepS.add(each.getText());
        }
        for (WebElement each : allDep) {
            allDepS.add(each.getText());
        }
        for (String each : mainDepS) {
            if (!allDepS.contains(each)) {
                System.out.println(each);
                System.out.println("This main dep is not in All departments list");
            }
        }
        Assert.assertTrue(allDep.containsAll(mainDepS));
    }


    @BeforeMethod
    public void setUp() {


        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

