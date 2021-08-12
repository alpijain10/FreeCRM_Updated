package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import  com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

//    @FindBy(xpath="//span[contains(text(),'Alpi  Jain')]")
//    WebElement userNameLabel;

    @FindBy(xpath = "//span[@class='user-display']")
    WebElement userNameLabel;

    @FindBy(xpath="//div[contains(@class,'fixed vertical')]")
    WebElement leftMenuPanel;

    @FindBy(xpath = "//a[@href='/companies']//preceding::button[1]")
    WebElement contactAddBtn;

    @FindBy(xpath = "//a[@href='/deals']//preceding::button[1]")
    WebElement companyAddBtn;

    @FindBy(xpath = "//a[@href='/tasks']//preceding::button[1]")
    WebElement dealsAddBtn;

    @FindBy(xpath = "//a[@href='/cases']//preceding::button[1]")
    WebElement taskAddBtn;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactslink;

    @FindBy(xpath = "//span[contains(text(),'Company')]")
    WebElement companylink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasksLink;

    @FindBy(xpath="//span[@class='user-display']")
    WebElement homepage;

   // private WebDriver;

    //Initialising the page Objects
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyuserName()
    {
        System.out.println(userNameLabel.getText());

        return userNameLabel.isDisplayed();
    }

    public String lblusername()
    {
        return  userNameLabel.getText();
    }

    public ContactsPage clickOnAddContacts()
    {
        Actions action=new Actions(driver);
        action.moveToElement(leftMenuPanel).build().perform();
        action.moveToElement(contactAddBtn).build().perform();
        contactAddBtn.click();
        action.moveToElement(homepage).build().perform();
        return new ContactsPage();
    }

    public TaskPage clickOnAddTasks()
    {
        Actions action =new Actions(driver);
        action.moveToElement(leftMenuPanel);
        action.moveToElement(taskAddBtn).build().perform();
        taskAddBtn.click();
        action.moveToElement(homepage);
        return new TaskPage();
    }

    public DealsPage clickOnAddDeals()
    {
        TestUtil.moveToElement(leftMenuPanel);
        TestUtil.setFocusClick(dealsAddBtn);
        TestUtil.setFocusClick(homepage);
        return new DealsPage();


//        Actions action=new Actions(driver);
//        action.moveToElement(leftMenuPanel);
//        action.moveToElement(dealsAddBtn).build().perform();
//        dealsAddBtn.click();
      //  action.moveToElement(homepage);

    }
    public ViewTaskPage clickOnTasktab()
    {
    Actions action=new Actions(driver);
    action.moveToElement(leftMenuPanel);
    action.moveToElement(tasksLink).build().perform();
    tasksLink.click();
    action.moveToElement(homepage);
    return new ViewTaskPage();
    }

    public ViewContactsPage clickOnContacttab()
    {
        Actions action= new Actions(driver);
        action.moveToElement(leftMenuPanel).build().perform();
        contactslink.click();

        action.moveToElement(homepage).build().perform();
        return new ViewContactsPage();
    }

    public DealsPage clickOnDeals()
    {
        Actions action= new Actions(driver);
        action.moveToElement(leftMenuPanel).build().perform();
        leftMenuPanel.click();

        dealsLink.click();
        return new DealsPage();
    }




}
