package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends TestBase {

    LoginPage objloginPage;
    HomePage objhomePage;
    ContactsPage objContactPage;
    ViewContactsPage objViewContact;
    SaveContactPage objSaveContact;
    TaskPage objTaskPage;
    ViewTaskPage objViewTaskPage;
    SaveTaskPage objSaveTaskPage;
    DealsPage objDealPage;
    String sheetName="Contacts";
    SoftAssert softAssert1;


    public HomePageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        objloginPage=new LoginPage();
        objContactPage=new ContactsPage();
        objViewContact=new ViewContactsPage();
        objSaveContact=new SaveContactPage();
        objTaskPage=new TaskPage();
        objViewTaskPage=new ViewTaskPage();
        objSaveTaskPage=new SaveTaskPage();
        objDealPage=new DealsPage();
        objhomePage=objloginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void TC01_VerifyHomePageTitleTest()
    {
        String homepagetitle= objhomePage.verifyHomePageTitle();
        Assert.assertEquals(homepagetitle,"Cogmento CRM","HomePage title doesn't match");

    }

    @Test(priority = 2)
    public void TC02_VerifyCorrectUserNameTest()
    {
        String uname=objhomePage.lblusername();
        System.out.println("Username" +uname);
        boolean flag=objhomePage.verifyuserName();
        Assert.assertTrue(flag);

    }


//    @DataProvider
//    public Object[][] getCRMTestData()
//    {
//        Object data[][]= TestUtil.getTestData(sheetName);
//        return data;
//    }

    @Test (priority = 2)
    public void TC03_VerifyContactAddbtn()
    {
        objContactPage=objhomePage.clickOnAddContacts();
           Assert.assertTrue(objContactPage.verifyContactlbl(),"Create New Contact text not present");

    }

    @Test(priority = 2)
    public void TC04_VerifyContactLinkTest()
    {
        objViewContact= objhomePage.clickOnContacttab();
        Assert.assertTrue(objViewContact.verifyContactLabel(),"Contact text not present in label");

    }

//    @Test(priority = 3)
//    public void TC05_verifyTaskLinkTest()
//    {
//        objViewTaskPage=objhomePage.clickOnTasktab();
//    }
//
//    @Test(priority = 3)
//    public void TC06_verifyDealLinkTest(){
//        objDealPage=objhomePage.clickOnDeals();
//    }

    @AfterMethod

    public void tearDown()
    {
        driver.quit();
    }


}
