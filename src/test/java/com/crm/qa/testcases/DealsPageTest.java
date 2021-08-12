package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.*;

public class DealsPageTest extends TestBase {

    LoginPage objloginPage;
    DealsPage objDealPage;
    HomePage objhomePage;
    TestUtil objutil;
    public DealsPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        objloginPage=new LoginPage();
        objDealPage=new DealsPage();
        objhomePage=objloginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        objDealPage=objhomePage.clickOnAddDeals();

    }

    @Test(enabled = false)
    public void VerifyTitle()
    {
        String title= objDealPage.getDealPageTitle();
        System.out.println(title);
    }

    @Test(enabled = true)
    public void addDeal()
    {
        objDealPage.createDeal();
        //TestUtil.takeScreenshotAtEndOfTest();
    }

    @AfterMethod
    public void tearDown()
    {
        objloginPage.logout();
       driver.quit();
    }


}
