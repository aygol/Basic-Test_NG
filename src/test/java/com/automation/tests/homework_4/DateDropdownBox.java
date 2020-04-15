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

import java.time.Year;
import java.util.*;
import java.util.Random;

public class DateDropdownBox {
//DAYS1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox2.
// Randomlyselect a checkbox. As soon as you check any day,
// print the name of the day and uncheck immediately.
// After you check and uncheck Friday for the third time,
// exit the program. NOTE: Remember some checkboxes are not selectable.
// You need to find a way to ignore them when they are randomly selected. It has to be dynamic.
// Do not hard code Saturday and Sunday.
// Use values of certain attributes.
    private WebDriver driver;

    @Test
    public void checkBoxTest() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(5);
        Random random = new Random();
        int count = 0;
        while (count < 3) {

            BrowserUtils.wait(3);
            String[] day = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            int index = random.nextInt(7);
            WebElement boxname = driver.findElement(By.id("gwt-debug-cwCheckBox-" + day[index] + "-label"));
            WebElement box = driver.findElement(By.id("gwt-debug-cwCheckBox-" + day[index]+"-input"));
            if (box.isEnabled()) {     //id="gwt-debug-cwCheckBox-Saturday-input"
                BrowserUtils.wait(2);
                if (boxname.getText().equals("Friday")) {
                    count++;
                    box.click();
                    BrowserUtils.wait(1);
                    System.out.println(boxname.getText());
                    box.click();

                } else {
                    box.click();
                    BrowserUtils.wait(1);
                    System.out.println(boxname.getText());
                    box.click();

                }
            }
        }}
    @Test
        public void daysTest() {
        //  1.go to http://practice.cybertekschool.com/dropdown
        //  2.verify that dropdowns under Select your date of birth display current year, month,
        //  dayYEARS, MONTHS,
        //  DAYS1.go tohttp://practice.cybertekschool.com/dropdown   2.select a random
        //  yearunder Select your date of birth  3.select month January   4.verify that days dropdown has current number ofdays
        //  5.repeat steps 3, 4
        //  for all the monthsNOTE: if you randomly select a leap year, verify February has 29 days
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        String todayDate = "March/26/2020";
        String[] date = todayDate.split("/");


        WebElement year = (driver.findElement(By.xpath("//option[@value=" + date[2] + "]")));
        BrowserUtils.wait(2);
        WebElement months = (driver.findElement(By.xpath("//*[@id=\"month\"]/option[text()="+"'"+date[0]+"'"+"]")));
        BrowserUtils.wait(2);
        WebElement day = (driver.findElement(By.xpath("//option[@value=" + date[1] + "]")));
//        System.out.println(year.getText());
//        System.out.println(months.getText());
//        System.out.println(day.getText());
        BrowserUtils.wait(2);
        Assert.assertTrue( (months.getText()+"/"+day.getText()+"/"+year.getText()).equals( todayDate));

    }@Test
    public void testleapYear(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
        List<WebElement>years=selectYear.getOptions();
        List<WebElement>month=selectMonth.getOptions();

        Random rg = new Random();
        int randomInt = rg.nextInt(99);
                for(int i=0;i<month.size();i++) {

                 BrowserUtils.wait(3);
                 selectYear.selectByVisibleText(years.get(randomInt).getText());
                 selectMonth.selectByVisibleText(month.get(i).getText());
                 List<WebElement>days=selectDay.getOptions();
                  BrowserUtils.wait(4);
                  //leap year value%400==0||leap year value%4==0||leap year value%100!=0||
                    int actualDays =days.size();
                    System.out.println(days.size());
                    if (Year.isLeap(Integer.parseInt(years.get(randomInt).getText()))&&(month.get(1).getText()=="February")){
                        Assert.assertTrue(29==actualDays);
                    }
                    }
                //@Test     mentoring how to find today date
        //public void todays_date(){
        //    driver.get("http://practice.cybertekschool.com/dropdown");
        //    WebElement year = driver.findElement(By.id("year"));
        //    WebElement month = driver.findElement(By.id("month"));
        //    WebElement day = driver.findElement(By.id("day"));
        //    Select y = new Select(year);
        //    Select m = new Select(month);
        //    Select d = new Select(day);
        //    String year_value = y.getFirstSelectedOption().getText();
        //    String month_value = m.getFirstSelectedOption().getText();
        //    String day_value = d.getFirstSelectedOption().getText();
        //    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");
        //    Assert.assertEquals(year_value+month_value+day_value, sf.format(new Date()));
        //}
    }
      @BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().version("79").setup();
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




