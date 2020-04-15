package com.automation.tests.homework_5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DayTimeUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomeWork_5 {
    private WebDriver driver;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
    private By endTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_end-uid']");
    private By visibility_cellBy = By.xpath("//*[@class='visibility-cell']");
    private By gridSettingsBy = By.xpath("//*[@title='Grid Settings']");
    private By calender_eventBy = By.xpath("//*[@class='btn-group']/a[@href='/calendar/event/create']");
    private By dropDownButtonBy = By.xpath("//*[@class='btn-success btn dropdown-toggle']");
    private By dropDownMenuBy = By.xpath("//*[@class='dropdown-menu']");
    private By endDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_end-uid']");

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");

        driver.get("https://qa1.vytrack.com/user/login");

        driver.manage().window().maximize();

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(6);
    }

    //hover over Activities
    @Test
    public void test1() {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Hover on three dots “…” for “Testers meeting”
        //calendar event
        //5. Verify that “view”, “edit” and “delete” options
        //are available
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);


        WebElement threeDots = driver.findElement(By.xpath("//td[text()='Testers Meeting']//..//td[@class='action-cell grid-cell grid-body-cell']"));


        actions.moveToElement(threeDots).pause(2000).perform();
        BrowserUtils.wait(3);


        WebElement viewOption = driver.findElement(By.xpath("//li[@class='launcher-item']//a[@title='View']"));
        WebElement editOption = driver.findElement(By.xpath("//li[@class='launcher-item']//a[@title='Edit']"));
        WebElement deleteOption = driver.findElement(By.xpath("//li[@class='launcher-item']//a[@title='Delete']"));
        actions.moveToElement(deleteOption).pause(300).perform();
        BrowserUtils.wait(3);
        Assert.assertTrue(deleteOption.isDisplayed());
        BrowserUtils.wait(3);
        actions.moveToElement(viewOption).pause(300).perform();
        BrowserUtils.wait(3);
        Assert.assertTrue(viewOption.isDisplayed());
        BrowserUtils.wait(3);
        actions.moveToElement(editOption).pause(300).perform();
        BrowserUtils.wait(3);
        Assert.assertTrue(editOption.isDisplayed());

    }

    @Test

    public void test2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);
        WebElement gridSetting = driver.findElement(gridSettingsBy);
        gridSetting.click();
        BrowserUtils.wait(3);
        List<WebElement> vivibility_cells = driver.findElements(visibility_cellBy);
        BrowserUtils.wait(3);
        for (int i = 0; i < vivibility_cells.size() - 1; i++) {
            vivibility_cells.get(i + 1).click();
            WebElement title = driver.findElement(By.xpath("(//*[@class='grid-header-cell__label'][text()='Title'])[1]"));
            Assert.assertEquals(title.getText().toLowerCase(), ("Title").toLowerCase());
        }
    }

    @Test
    public void test3() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(3);
        WebElement dropDown = driver.findElement(dropDownButtonBy);
        dropDown.click();
        BrowserUtils.wait(3);
        WebElement saveAndClose = driver.findElement(By.xpath("//*[@class='action-button dropdown-item']"));
        BrowserUtils.wait(3);
        Assert.assertEquals(saveAndClose.getText().trim().toLowerCase(), "Save and Close".toLowerCase());
        List<String> dropdown_StringName = Arrays.asList("Save and New", "Save");
        List<WebElement> dropDown_menu = driver.findElements(By.xpath("//*[@class='main-group action-button dropdown-item']"));////button[@type='submit']
        BrowserUtils.wait(3);
        for (int i = 0; i < dropDown_menu.size(); i++) {
            System.out.println(dropDown_menu.get(i).getText());
            BrowserUtils.wait(3);
            Assert.assertEquals(dropDown_menu.get(i).getText().toLowerCase().trim(), (dropdown_StringName.get(i).toLowerCase()));
        }
    }

    @Test
    public void test4() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(3);
        WebElement cancelButton = driver.findElement(By.xpath("(//*[@data-action='cancel'])[1]"));
        cancelButton.click();
        BrowserUtils.wait(4);
        WebElement subTitle = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        BrowserUtils.wait(3);
        Assert.assertTrue(subTitle.getText().contains("Calendar Events"));
        BrowserUtils.wait(3);
    }

    @Test
    public void test5() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(4);

        String startTime = driver.findElement(startTimeBy).getAttribute("value");
        BrowserUtils.wait(4);

        String endTime = driver.findElement(endTimeBy).getAttribute("value");
        BrowserUtils.wait(4);

        String format = "h:m a";
        long actual = DayTimeUtilities.getTimeDifference(startTime, endTime, format);
        Assert.assertEquals(actual, 1);


    }

    @Test
    public void test6() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(4);

        Select select = new Select(driver.findElement(By.xpath("/html/body/div[6]/ul/li[43]")));
        select.selectByValue("9:00 PM");

        BrowserUtils.wait(5);
        String endTime = driver.findElement(endTimeBy).getAttribute("value");
        BrowserUtils.wait(3);
        Assert.assertEquals(endTime, "10:00 PM");
    }

    @Test
    public void test7() {
        Actions actions = new Actions(driver);
        //   WebElement repeatCheckbox=driver.findElement(By.xpath("//*[@type='checkbox'][contains(@id,'recurrence-repeat')]"));

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(4);
        WebElement checkbox = driver.findElement(By.xpath("//*[contains(@id,'oro_calendar_event_form_allDay-uid')]"));
        checkbox.click();//
        BrowserUtils.wait(4);
        Assert.assertTrue(!driver.findElement(startTimeBy).isDisplayed());
        BrowserUtils.wait(4);
        Assert.assertTrue(!driver.findElement(endTimeBy).isDisplayed());
        BrowserUtils.wait(4);
        Assert.assertTrue(driver.findElement(startDateBy).isDisplayed());
        BrowserUtils.wait(4);
        Assert.assertTrue(driver.findElement(endDateBy).isDisplayed());
    }

    @Test
    public void test8() {
        //5. Select “Repeat” checkbox
        //6. Verify that “Repeat” checkbox is selected
        //7. Verify that “Daily” is selected by default and
        //following options are available in
        //“Repeats” drop-down:
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(4);
        WebElement repeatCheckbox = driver.findElement(By.xpath("//*[@data-name='recurrence-repeat']"));
        repeatCheckbox.click();
        BrowserUtils.wait(3);
        Select select = new Select(driver.findElement(By.xpath("//*[@class='recurrence-repeats__select']")));
        BrowserUtils.wait(3);
        List<WebElement> repeatOptions = select.getOptions();
        BrowserUtils.wait(3);
        List<String> expected = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        BrowserUtils.wait(3);
        for (int i = 0; i < repeatOptions.size(); i++) {
            Assert.assertTrue(repeatOptions.get(0).isSelected());
            BrowserUtils.wait(3);
            Assert.assertEquals(repeatOptions.get(i).getText(), expected.get(i));

        }
    }

    @Test
    public void test9() {
        //5. Select “Repeat” checkbox
        //6. Verify that “Repeat” checkbox is selected
        //7. Verify that “Repeat Every” radio button is
        //selected
        //8. Verify that “Never” radio button is selected as an
        //“Ends” option.
        //9. Verify that following message as a summary is
        //displayed: “Summary: Daily every 1 day”
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(4);
        WebElement repeatCheckbox = driver.findElement(By.xpath("//*[@data-name='recurrence-repeat']"));
        repeatCheckbox.click();
        BrowserUtils.wait(3);
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        if (radioButtons.get(2).isSelected()) {
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='recurrence-subview-control__text']")).getText().equals("Never"));
            System.out.println();
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'oro_calendar_event_form-uid-')]//label[text()='Ends']")).getText().equals("Ends"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='control-label wrap']/label[text()='Summary:']")).getText().equals("Summary:"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='controls']/div/span[text()='Daily every 1 day']")).getText().equals("Daily every 1 day"));

        }
    }

    @Test
    public void test10() {

//5. Select “Repeat” checkbox
//6. Select “After 10 occurrences” as an “Ends” option.
//7. Verify that following message as a summary is
//displayed: “Summary: Daily every 1 day, end
//after 10 occurrences”
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(4);
        WebElement repeatCheckbox = driver.findElement(By.xpath("//*[@data-name='recurrence-repeat']"));
        repeatCheckbox.click();
        BrowserUtils.wait(3);
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        WebElement occurancesTextBox = driver.findElement(By.xpath("//*[@type='text'][@data-related-field='occurrences']"));
        BrowserUtils.wait(3);

        occurancesTextBox.click();
        occurancesTextBox.sendKeys("10", Keys.ENTER);
        BrowserUtils.wait(3);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='controls']/div/span[2]")));

        if (radioButtons.get(3).isSelected()) {

            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='recurrence-subview-control__text'][text()='occurrences']")).getText().equals("occurrences"));
            BrowserUtils.wait(3);
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'oro_calendar_event_form-uid-')]//label[text()='Ends']")).getText().equals("Ends"));
            BrowserUtils.wait(3);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='controls']/div/span[text()='Daily every 1 day']")).getText().equals("Daily every 1 day"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='controls']/div/span[2]")).getText().equals(", end after 10 occurrences"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='control-label wrap']/label[text()='Summary:']")).getText().equals("Summary:"));
        }
    }

    @Test
    public void test11() {
        //5. Select “Repeat” checkbox
        //6. Select “By Nov 18, 2021” as an “Ends” option.
        //7. Verify that following message as a summary is
        //displayed: “Summary: Daily every 1 day, end by
        //Nov 18, 2021
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(2);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(2);
        WebElement repeatCheckbox = driver.findElement(By.xpath("//*[@data-name='recurrence-repeat']"));
        repeatCheckbox.click();
        BrowserUtils.wait(3);
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        radioButtons.get(4).click();
        WebElement choseDate = driver.findElement(By.xpath("(//*[@placeholder='Choose a date'])[3]"));
        choseDate.click();
        BrowserUtils.wait(2);
        Select months = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")));
        months.selectByValue("10");
        Select yearSelect = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));
        yearSelect.selectByValue("2021");
        BrowserUtils.wait(3);

        List<WebElement> days = driver.findElements(By.xpath("//*[@class='ui-state-default']"));
        days.get(17).click();
        BrowserUtils.wait(3);
        BrowserUtils.wait(3);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='controls']/div/span[text()='Daily every 1 day']")).getText().equals("Daily every 1 day"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='controls']/div/span[2]")).getText().equals(", end by Nov 18, 2021"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='control-label wrap']/label[text()='Summary:']")).getText().equals("Summary:"));
//
    }

    @Test
    public void test12() {
        //Select “Weekly” options as a “Repeat” option
        //7. Select “Monday and Friday” options as a
        //“Repeat On” options
        //8. Verify that “Monday and Friday” options are
        //selected
        //9. Verify that following message as a summary is
        //displayed: “Summary: Weekly every 1 week on
        //Monday, Friday”
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(2);
        WebElement calenderEventCreate = driver.findElement(calender_eventBy);
        calenderEventCreate.click();
        BrowserUtils.wait(2);
        WebElement repeatCheckbox = driver.findElement(By.xpath("//*[@data-name='recurrence-repeat']"));
        repeatCheckbox.click();
        BrowserUtils.wait(3);
        WebElement recurrence = driver.findElement(By.xpath("//*[@data-name='recurrence-repeats']"));
        recurrence.click();
        WebElement weekly = driver.findElement(By.xpath("//*[contains(@id, 'recurrence-repeats-view')]/option[2]"));
        weekly.click();
        WebElement monday = driver.findElement(By.xpath("(//*[@class='multi-checkbox-control__item'] )[2]"));
        monday.click();
        WebElement friday = driver.findElement(By.xpath("(//*[@class='multi-checkbox-control__item'] )[6]"));
        friday.click();
        System.out.println(driver.findElement(By.xpath("(//*[@class='controls']/div/span)[6]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='controls']/div/span)[6]")).getText().equals("Weekly every 1 week on Monday, Friday"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='control-label wrap']/label[text()='Summary:']")).getText().equals("Summary:"));


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }}
