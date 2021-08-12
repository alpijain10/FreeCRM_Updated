package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.Test;


public class DealsPage extends TestBase {

    @FindBy (name="title")
    WebElement deal_title;

    @FindBy(xpath="//button[text()='Save']")
    WebElement deal_savebtn;

    @FindBy(xpath="//label[text()='Identifier']")
    WebElement deal_identifier;


    @FindBy(xpath = "//div[@name='type' and @role='listbox']")
    WebElement deal_type;

    @FindBy(xpath = "//span[text()='Opportunity']//parent::div[1]")
    WebElement deal_type_Opp    ;

    //initialising page objects

    public DealsPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getDealPageTitle()
    {
        return driver.getTitle();

    }

    public SaveDealPage createDeal()
    {
        deal_title.sendKeys("FREE30");
        deal_type.click();
        deal_type_Opp.click();
        TestUtil.flash(deal_savebtn,driver);
        TestUtil.takeElementScreenshot(deal_type,"dealType_snaphot");
        TestUtil.takeElementScreenshot(deal_savebtn,"savebtnsnapshot");
       // deal_savebtn.click();
        TestUtil.scrollPageDown(driver);
//        try {
//            TestUtil.takeScreenshotAtEndOfTest();
//        }catch (Exception e){e.printStackTrace();}
//        System.out.println("Deal Created");
        TestUtil.scrollIntoView(deal_identifier,driver);
        TestUtil.takeElementScreenshot(deal_identifier,"labelsnapshot");

        return new SaveDealPage();

    }



}
