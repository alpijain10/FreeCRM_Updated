package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TestUtil extends TestBase {
    public static  long PAGE_LOAD_TIMEOUT=20;
    public static long  IMPLICIT_WAIT=10;
    public static final String driverPath = "C:\\Program Files\\selenium-java-3.14\\Drivers";
    public static String TESTDATA_SHEET_PATH="C:\\Users\\nisha\\IdeaProjects\\FreeCRM_Updated\\src\\main\\java\\com\\crm\\qa\\testData\\FreeCRMTestData1.xlsx";
    String reportFilePath =" C:\\Users\\nisha\\IdeaProjects\\FreeCRM_Updated\\src\\main\\resources\\Report";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();
                System.out.println(data[i][k]);
            }
        }
        return data;
    }

    public void setFocusEnter(WebElement element, String value) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.sendKeys(value);
        action.sendKeys(Keys.DOWN);
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }
    public static void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();
    }
    public static void setFocus(WebElement element, String value) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.click();
        action.sendKeys(value);
        action.build().perform();
    }

    public void sendKeysEnter(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.click();
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }

    public void setFocusdblClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.doubleClick();
        action.build().perform();
    }
    public static void setFocusClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.click();
        action.build().perform();
    }
    public void sendKeysDownClick(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.sendKeys(Keys.DOWN);
        action.build().perform();
    }
    public static void sendKeysDownClickEnter(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.sendKeys(Keys.DOWN);
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }
    public static void emptyTextData(WebElement element){
        element.sendKeys(Keys.CONTROL+"a");
        element.sendKeys(Keys.DELETE);
    }
//    public boolean fnWaitForVisibility(WebElement element , int waitFor){
//        WebDriverWait wait = new WebDriverWait(driver,waitFor);
//        wait.until(ExpectedConditions.visibilityOf(element));
//        return element.isDisplayed();
//    }

    public static void takeScreenshotAtEndOfTest() throws IOException{
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        FileUtils.copyFile(scrFile,new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));

    }

    public static void closeBrowser()
    {
        driver.quit();
    }

    //function to take webelement screenshot
    public static void takeElementScreenshot(WebElement element,String fileName)
    {
        File srcFile=element.getScreenshotAs(OutputType.FILE);
        try{
            String currentDir=System.getProperty("user.dir");
            FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+ fileName     + ".png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void flash(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js= ((JavascriptExecutor)driver);
        String bgcolor=element.getCssValue("backgroundColor");
        for(int i=0;i<5;i++)
        {
            changeColor("rgb(0,200,0)",element,driver);
            changeColor(bgcolor,element,driver);
            drawBorder(element,driver);
        }
    }
    public static void changeColor(String color,WebElement element,WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
        try{
            Thread.sleep(10);
                    }catch (InterruptedException e)
        {     }

    }

        public static void drawBorder(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'",element);

    }

    public static void scrollPageDown(WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public static void scrollIntoView(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("argument[0].scrollIntoView(true);",element);
        try{
            Thread.sleep(20);
        }catch (InterruptedException ie)
        {

        }

    }

}
