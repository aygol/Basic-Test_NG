package com.automation.tests.homework_4;

public class MentoringForHmwork4 {
//    @Test
//    public void days(){
//        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
//        List<WebElement> l1 = driver.findElements(By.cssSelector(".gwt-CheckBox>label"));
//        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".gwt-CheckBox>input"));
//        Random r = new Random();
//        int count = 0;
//        while(count<3){
//            // this method will return any value between 0 and 7
//            int index = r.nextInt(l1.size());
//            if(checkboxes.get(index).isEnabled()){
//                l1.get(index).click();
//                if(l1.get(index).getText().equals("Friday")){
//                    count++;
//                }
//                System.out.println(l1.get(index).getText());
//                l1.get(index).click();
//            }
//        }
//    }
//}
//    @Test
//    public void todays_date(){
//        driver.get("http://practice.cybertekschool.com/dropdown");
//        WebElement year = driver.findElement(By.id("year"));
//        WebElement month = driver.findElement(By.id("month"));
//        WebElement day = driver.findElement(By.id("day"));
//        Select y = new Select(year);
//        Select m = new Select(month);
//        Select d = new Select(day);
//        String year_value = y.getFirstSelectedOption().getText();
//        String month_value = m.getFirstSelectedOption().getText();
//        String day_value = d.getFirstSelectedOption().getText();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");
//        Assert.assertEquals(year_value+month_value+day_value, sf.format(new Date()));
//    @Test
//    public void years_months_days(){
//        driver.get("http://practice.cybertekschool.com/dropdown");
//        WebElement year = driver.findElement(By.id("year"));
//        WebElement month = driver.findElement(By.id("month"));
//        WebElement day = driver.findElement(By.id("day"));
//        Select y = new Select(year);
//        Select m = new Select(month);
//        Select d = new Select(day);
//        Random r = new Random();
//        int index = r.nextInt(y.getOptions().size());
//        y.selectByIndex(index);
//        List<String> months31 = new ArrayList<>(Arrays.asList(new String[]{"January", "March", "May", "July", "August", "October", "December"}));
//        int febDays;
//        int yearValue = Integer.parseInt(y.getFirstSelectedOption().getText());
//        if(yearValue %400==0 || (yearValue%4 ==0 && yearValue %100!=0)){
//            febDays=29;
//        }else{
//            febDays=28;
//        }
//        for(int i =0; i<12; i++){
//            m.selectByIndex(i);
//            if(months31.contains(m.getFirstSelectedOption().getText())){
//                Assert.assertEquals(d.getOptions().size(), 31);
//            }else if(m.getFirstSelectedOption().getText().equals("February")){
//                Assert.assertEquals(d.getOptions().size(), febDays);
//            }else{
//                Assert.assertEquals(d.getOptions().size(), 30);
//            }
//        }
//    }
}
