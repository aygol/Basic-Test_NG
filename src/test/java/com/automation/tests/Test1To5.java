package com.automation.tests;

import com.automation.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Test1To5 {

    private WebDriver driver;
//    Step 2. Click on “Registration Form”
//    Step 3. Enter “wrong_dob” into date of birth input
//    box.
//            Step 4. Verify that warning message is displayed:
//            “The date of birth is not valid”
    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private By registration=By.xpath("//*[@id='content']/ul/li[40]/a");
    private By warningMessageBy = By.xpath("//*[@id='registrationForm']/div[8]/div/small[2]");
    private By userName=By.name("username");
    private By lastName=By.name("lastname");
    @Test(description = "Verify that warning message displays when user enters invalid date of birth")
        public void invalidDateOfBirth(){
        driver.findElement(registration).click();
        BrowserUtils.wait(4);
        driver.findElement(By.xpath("//*[@placeholder='MM/DD/YYYY']")).sendKeys("13/21/2020");
        BrowserUtils.wait(4);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
        BrowserUtils.wait(4);
        String expected="The date of birth is not valid";
        BrowserUtils.wait(4);
        String actual=warningElement.getText();
        BrowserUtils.wait(5);
        Assert.assertEquals(actual,expected,"actual and expected not same");

//Step 1. Go to “https://practice-cybertekschool.herokuapp.com”Step
// 2. Click on “Registration Form”Step
// 3. Verify that following options for programming languages are
// displayed: c++, java, JavaScript
    }@Test
    public void languagestest2(){
        driver.findElement(registration).click();
        BrowserUtils.wait(4);
        WebElement cPlus=driver.findElement(By.xpath("//*[@for='inlineCheckbox1']"));
        BrowserUtils.wait(4);
        WebElement java=driver.findElement(By.xpath("//*[@for='inlineCheckbox2']"));
        BrowserUtils.wait(4);
        WebElement javaScript=driver.findElement(By.xpath("//*[@for='inlineCheckbox3']"));
        System.out.println(cPlus.getText());
        String actual1="C++";
        String actual2="Java";
        String actual3="JavaScript";
        Assert.assertEquals(cPlus.getText(),actual1);
        BrowserUtils.wait(4);
        Assert.assertEquals(java.getText(),actual2);
        BrowserUtils.wait(4);
        Assert.assertEquals(javaScript.getText(),actual3);

    }
    // Step 3. Enter only one alphabetic character into
    // first name input box.Step 4. Verify that warning message is displayed:
    // “first name must be more than 2 and less than 64 characters long”
    @Test(description = "Verify that warning message is displayed")
    public void nameTest3(){
        driver.findElement(registration).click();
        BrowserUtils.wait(4);
     driver.findElement(userName).sendKeys("a");
        BrowserUtils.wait(2);
        String actual=driver.findElement(By.xpath("//*[@data-bv-result='INVALID'][text()='The username must be more than 6 and less than 30 characters long']")).getText();
        BrowserUtils.wait(2);
        String expected="The username must be more than 6 and less than 30 characters long";
        BrowserUtils.wait(4);
        Assert.assertEquals(actual,expected);
    }
    //Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
    // 2. Click on “Registration Form”
    // 3. Enter only one alphabetic character into last name input box.
    // 4. Verify that warning message is displayed:
    // “The last name must be more than 2 and less than 64 characters long
@Test(description = "Verify that warning message is displayed")
public void lastnametest4(){
    driver.findElement(registration).click();
    BrowserUtils.wait(4);
    driver.findElement(lastName).sendKeys("a");
    BrowserUtils.wait(2);
    String actual=driver.findElement(By.xpath("//*[@data-bv-for='lastname'][text()='The last name must be more than 2 and less than 64 characters long']")).getText();
    BrowserUtils.wait(2);
    String expected="The last name must be more than 2 and less than 64 characters long";
    BrowserUtils.wait(4);
    Assert.assertEquals(actual,expected);


}
//Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
// Step 2. Click on “Registration Form”
// Step 3. Enter any valid first name.
// Step 4. Enter any valid last name.
// Step 5. Enter any valid user name.
// Step 6. Enter any valid password.
// Step 7. Enter any valid phone number.
// Step 8. Select gender.
// Step 9. Enter any valid date of birth.
// 10. Select any department.
// Step 11. Enter any job title.
// Step 12. Select java as a programming language.
// Step 13. Click Sign up.
// Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
 @Test()
 public void formtest5(){
     driver.findElement(registration).click();
     BrowserUtils.wait(4);
     driver.findElement(By.name("firstname")).sendKeys("Suzan");
     BrowserUtils.wait(4);
     driver.findElement(By.name("lastname")).sendKeys("Selek");
     BrowserUtils.wait(4);
     driver.findElement(userName).sendKeys("SelekSuzan");
     BrowserUtils.wait(2);
     driver.findElement(By.name("email")).sendKeys("selek@gmail.com");
     BrowserUtils.wait(4);
     driver.findElement(By.name("password")).sendKeys("se123Suz");
     BrowserUtils.wait(4);
     driver.findElement(By.name("phone")).sendKeys("954-934-2312");
     BrowserUtils.wait(4);
   WebElement buttonFemale=  driver.findElement(By.xpath("//*[@value='female']"));//.click();
     if(buttonFemale.isDisplayed()&&!buttonFemale.isSelected()){
         BrowserUtils.wait(4);
         buttonFemale.click();
     }
     driver.findElement(By.xpath("//*[@placeholder='MM/DD/YYYY']")).sendKeys("12/21/2004");
     BrowserUtils.wait(4);
     WebElement depart= driver.findElement(By.xpath("//*[@name='department']"));
     BrowserUtils.wait(2);
     Select department=new Select(depart);
     department.selectByVisibleText("Department of Engineering");
     BrowserUtils.wait(3);
     WebElement jobTitle=driver.findElement(By.xpath("//*[@name='job_title']"));
     BrowserUtils.wait(2);
     Select job=new Select(jobTitle);
     job.selectByVisibleText("SDET");
     BrowserUtils.wait(2);
    WebElement box= driver.findElement(By.xpath("//*[@value='java']"));
     BrowserUtils.wait(4);
     if(!box.isSelected()){
         BrowserUtils.wait(2);
         box.click();
     }

    WebElement submit=driver.findElement(By.id("wooden_spoon"));
     BrowserUtils.wait(4);
     submit.click();
     String expected="You've successfully completed registration!";
     BrowserUtils.wait(3);
     String actual=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p")).getText();
     BrowserUtils.wait(3);
     Assert.assertEquals(actual,expected);
 }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
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


