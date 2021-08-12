package com.crm.qa.testcases;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.pages.HomePage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LoginPageTest extends TestBase {
    LoginPage objloginPage;
    HomePage objhomePage;
    public String destFile;

    public LoginPageTest(){
        super();

    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        objloginPage =new LoginPage();
    }

    @Test(priority = 1)
    public void TC01_LoginPageTitleTest()
    {
        String title= objloginPage.validationLoginPageTitle();
        Assert.assertEquals(title,"Cogmento CRM");
    }

    @Test(priority = 1)
    public void TC02_ValidatesignuplinkTest()
    {
       boolean flag= objloginPage.validatesignuplinkdisplay();
       Assert.assertTrue(flag);
    }
    @Test(priority = 2)
    public void TC03_LoginTest()
    {
        objhomePage=objloginPage.login(prop.getProperty("username"), prop.getProperty("password"));


    }

    @Test(priority = 3)
     public void TC04_Logoutfromapplication()
    {
        objhomePage=objloginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        objloginPage.logout();

    }



    @AfterMethod
    public void tearDown()
    {

        driver.quit();
    }

}
