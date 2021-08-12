package com.crm.qa.testcases;

import com.crm.qa.ExtentReportListener.ExtentReporterNG;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ContactsPageTest extends TestBase {

    LoginPage objloginPage;
    HomePage objhomePage;
    TestUtil objtestUtil;
    ContactsPage objContactPage;
    SaveContactPage objSaveContactPage;
    ViewContactsPage objViewContactPage;
    String sheetName="Contacts";

    public ContactsPageTest()
    {
        super();

    }
    @BeforeMethod
    public void setUp()
    {
        initialization();

        objloginPage=new LoginPage();
        objContactPage=new ContactsPage();
        objSaveContactPage=new SaveContactPage();
        objhomePage=objloginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        objContactPage=objhomePage.clickOnAddContacts();

    }

    @Test(enabled=true)
    public void TC01_VerifyContactLbl()
    {
        Assert.assertTrue(objContactPage.verifyContactlbl(),"contact label missing");
    }

    @DataProvider
    public Object[][] getCRMTestData()
    {
        Object data[][]=TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2,dataProvider = "getCRMTestData")
    public void TC02_ValidateCreateNewContact(String Fname,String Lname,String Email,String Category,String Status,String Source,String Assistant,String Position,String Company,String Tag,String Day,String Month,String Year)
    {
        objhomePage.clickOnAddContacts();
        objContactPage.addContactData(Fname,Lname,Email,Category,Status,Source,Assistant,Position,Company,Tag,Day,Month,Year);

    }

    @Test(enabled = true)
    public void TC03_Verify_elements_Presence_Contacts()
    {
        objhomePage.clickOnAddContacts();
        objContactPage.validate_elements_Presence();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}