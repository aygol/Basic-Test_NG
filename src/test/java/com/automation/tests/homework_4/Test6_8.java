package com.automation.tests.homework_4;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test6_8 {
private WebDriver driver;
private String URL="https://www.tempmailaddress.com/";
private By replyemail=By.xpath("//tbody/tr/td[1]");
////*[@id="predmet"]

//Step 1. Go to "https://www.tempmailaddress.com/"
//Step 2. Copy and save email as a string.
// Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
// Step 4. And click on “Sign Up For Mailing List".
// Step 5. Enter any valid name.Step 6. Enter email from the Step
// 2.Step 7. Click Sign UpStep 8. Verify that following message is displayed:
// “Thank you for signing up. Click the button below to return to the home page.”
// Step 9. Navigate back to the “https://www.tempmailaddress.com/”
// Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
// Step 11. Click on that email to open it.
// Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
// Step 13. Verify that subject is:
// “Thanks for subscribing to practice.cybertekschool.com!”
 @Test
 public void getEmail(){
     driver.get(URL);
     driver.manage().window().maximize();
     String email=driver.findElement(By.xpath("//*[@id='email']")).getText();
     BrowserUtils.wait(2);
     driver.get("https://practice-cybertekschool.herokuapp.com/");
     BrowserUtils.wait(3);
     driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
     BrowserUtils.wait(3);
     driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Emren Guler");
     BrowserUtils.wait(3);
     driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
     BrowserUtils.wait(3);
     driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
     BrowserUtils.wait(3);
     String actual=driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
     BrowserUtils.wait(3);
     String expected="Thank you for signing up. Click the button below to return to the home page.";
     Assert.assertEquals(actual,expected);
     //test gecti******
     BrowserUtils.wait(3);

     driver.get("https://www.tempmailaddress.com/");
     BrowserUtils.wait(1);
     Assert.assertTrue(driver.findElement(replyemail).isDisplayed());
     BrowserUtils.wait(1);
     driver.findElement(replyemail).click();
     BrowserUtils.wait(3);
     String actualemail=driver.findElement(By.id("odesilatel")).getText();
     BrowserUtils.wait(3);
     String expectedemail="do-not-reply@practice.cybertekschool.com";
     BrowserUtils.wait(2);
     Assert.assertEquals(actualemail,expectedemail);
     BrowserUtils.wait(2);
     String subjectActual=driver.findElement(By.id("predmet")).getText();
     BrowserUtils.wait(2);
     String subjectexpected="Thanks for subscribing to practice.cybertekschool.com!";
 }//Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    // Step 2. And click on “File Upload".
    // Step 3. Upload any file with .txt extension from your computer.
    // Step 4. Click “Upload” button.
    // Step 5. Verify that subject is: “File Uploaded!”
    // Step 6. Verify that uploaded file name is displayed.
    // Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
    // Run this method against “Choose File” button.
    @Test
    public void fileUpload(){
     driver.get("https://practice-cybertekschool.herokuapp.com");
     driver.manage().window().maximize();
     BrowserUtils.wait(5);
     driver.findElement(By.xpath("//*[@id='content']/ul/li[18]/a")).click();
     BrowserUtils.wait(3);
    // driver.findElement(By.xpath("//input[@id='file-upload']")).click();
    // BrowserUtils.wait(3);
     driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C://Users//golcu//OneDrive//Belgeler//file.txt");
     BrowserUtils.wait(4);
     driver.findElement(By.id("file-submit")).click();
     String actual=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
     BrowserUtils.wait(4);
     String expected="File Uploaded!";
     BrowserUtils.wait(4);
     Assert.assertEquals(actual,expected);
       ////h3[text()='File Uploaded!']
        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());
        //"uploaded-files
    }
  //  Test case #8 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    //  Step 2. And click on “Autocomplete”.
    //  Step 3. Enter “United States of America” into country input box.
    //  Step 4. Verify that following message is displayed: “You selected: United States of America”
   // Optional: If you want to to be a real selenium hero,
    // use @DataProvider for for tests cases
  @Test
    public void autocomplete() {
      driver.get("https://practice-cybertekschool.herokuapp.com");
      BrowserUtils.wait(3);
      driver.manage().window().maximize();
      BrowserUtils.wait(3);
      driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
      BrowserUtils.wait(4);
      driver.findElement(By.id("myCountry")).sendKeys("United States of America");
      BrowserUtils.wait(2);
      driver.findElement(By.xpath("//input[@type='button']")).click();
      BrowserUtils.wait(4);
     Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
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


