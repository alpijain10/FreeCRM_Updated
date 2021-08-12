package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaskPageTest extends TestBase {

    LoginPage objloginPage;
    HomePage objhomePage;
    TestUtil objtestUtil;
//    ContactsPage objContactPage;
//    SaveContactPage objSaveContactPage;
//    ViewContactsPage objViewContactPage;
    TaskPage objTaskPage;
    SaveTaskPage objSaveTaskPage;
    ViewTaskPage objViewTaskPage;
    String sheetName="Task";

    public TaskPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        objloginPage=new LoginPage();
        objhomePage=new HomePage();
        objTaskPage=new TaskPage();
        objSaveTaskPage =new SaveTaskPage();
        objViewTaskPage=new ViewTaskPage();
        objhomePage=objloginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        objTaskPage=objhomePage.clickOnAddTasks();

    }

    @Test(priority=1)
    public void verifyTasklbl()
    {
        Assert.assertTrue(objTaskPage.verifyTaskPageheader(),"Label Task missing");

    }

    @DataProvider
    public Object[][] getCRMTestData()
    {
        Object data[][]=TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2,dataProvider = "getCRMTestData")
    public void validateCreateNewTask(String Title,String AssignedTo,String Type,String DueDate,String Contact,String Deal,String Case,String CloseDate,String Tags,String Description,String Completion,String Priority,String Status,String Identifier)
    {
        //objhomePage.clickOnAddTasks();
        objTaskPage.addNewTaskData(Title,AssignedTo,Type,DueDate,Contact,Deal,Case,CloseDate,Tags,Description,Completion,Priority,Status,Identifier);


    }

    @AfterMethod
    public void tearDown()
    {
        objloginPage.logout();
        driver.quit();
    }

}
