package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.ExtentReportListener.ExtentReporterNG;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.security.KeyStore;
import java.util.List;

public class ContactsPage extends TestBase {

    TestUtil objtestUtil;

    @FindBy(xpath = "//div[text()='Create New Contact']")
    WebElement lblContact;

    @FindBy(xpath="//input[@name='first_name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@name='middle_name']")
    WebElement txtmdlName;


    @FindBy(xpath = "//div[@name='category' and @role='listbox']")
    WebElement catg;

    @FindBy(xpath = "//div[@role='combobox' and @name='assistant']//span[text()='Add ']")
    WebElement assist_Add;

    @FindBy(xpath = "//div[@name='status' and @role='listbox']")
    WebElement status;

    @FindBy(xpath = "//div[@name='source' and @role='listbox']")
    WebElement source;


    @FindBy(xpath = "//input[@type='text']//parent::div[@name='assistant' and @role='combobox']")
    WebElement assistant;

    @FindBy(xpath = "//input[@name='middle_name']//following::input[1]")
    WebElement companyName;

    @FindBy(xpath = "//label[text()='Access']/following::button[1]")
    WebElement accessBtn;

    @FindBy(xpath = "//span[@class='sizer']//parent::div[@role='combobox']")
    WebElement tagName;

    @FindBy(xpath = "//label[text()='Email']//following::input[1]")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name='position']//parent::div[@class='ui input']")
    WebElement position_field;

    @FindBy(xpath = "//button[text()='New']")
    WebElement newBtn;

    @FindBy(xpath = "//span[text()='Customer']")
    WebElement customer;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveBtn;

    @FindBy(xpath="//input[@name='do_not_call']")
    WebElement btndontcall;

    @FindBy(xpath="//input[@name='do_not_text']")
    WebElement btndonttext;
    @FindBy(xpath="//input[@name='do_not_email']")
    WebElement btndontemail;

    @FindBy(xpath="//input[@name='day']//parent::div[@class='ui small icon input']")
    WebElement birth_day;

    @FindBy(xpath = "//div[contains(text(),'Month')]//parent::div[@name='month']")
    WebElement birth_month;

    @FindBy(xpath="//input[@name='year']")
    WebElement birth_year;
    //Initialising page objects
    public ContactsPage()
    {
        PageFactory.initElements(driver, this);

    }

    public boolean verifyContactlbl()
    {
        return lblContact.isDisplayed();
    }


    public void addContactData(String fname,String lname,String emailid,String category,String status,String source,String assist_val,String pos,String val_company,String Tag,String day,String month,String year)
    {

        txtFirstName.sendKeys(fname);
        txtLastName.sendKeys(lname + Keys.TAB);
        txtmdlName.sendKeys("Alpi"+Keys.TAB);
        setCompany(val_company);
       // objtestUtil.fnWaitForVisibility(tagName,10);
        setTag(Tag);
        emailInput.sendKeys(emailid);
        setCategory(category);
        setStatus(status);
        setPosition(pos);
        setAssistant(assist_val);
        setSource(source);
        setDontCall();
        setDontText();
        setDontEmail();
        setBirthdate(day,month,year);
        saveBtn.click();
    }
    public void setCompanyName(String val_company)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(companyName).build().perform();
        actions.click(companyName).build().perform();

        actions.sendKeys(val_company,Keys.ENTER).build().perform();

    }
    public void setBirthdate(String bday,String month_value,String byear)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(birth_day).click().build().perform();
        actions.sendKeys(bday).build().perform();
        WebElement ele_month= driver.findElement(By.xpath("//span[contains(text(),'"+month_value+"')]//ancestor::div[@role='option']"));
        actions.moveToElement(birth_month).click().build().perform();
        actions.moveToElement(ele_month).build().perform();
        actions.click(ele_month).build().perform();
        actions.moveToElement(birth_year).click().build().perform();
        actions.sendKeys(byear).build().perform();

    }

    public void setDontCall()
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(btndontcall).build().perform();
        actions.click(btndontcall).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void setDontEmail()
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(btndontemail).build().perform();
        actions.click(btndontemail).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void setDontText()
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(btndonttext).build().perform();
        actions.click(btndonttext).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void setTag(String val_tag)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(tagName).build().perform();
        actions.click(tagName).build().perform();
        actions.sendKeys(val_tag+Keys.ENTER).build().perform();
    }


    public void setAssistant(String val_assistant)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(assistant).build().perform();
        actions.click(assistant).build().perform();
        actions.sendKeys(val_assistant).build().perform();
        //actions.moveToElement(assist_Add).click(assist_Add).build().perform();
    }

    public void setPosition(String position)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(position_field).build().perform();
        actions.click(position_field).build().perform();
        actions.sendKeys(position).build().perform();
    }

    public SaveContactPage saveContact()
    {
        saveBtn.click();
        return new SaveContactPage();
    }

    public void setCategory(String category_value)
    {
        Actions actions=new Actions(driver);
       WebElement ele_Category= driver.findElement(By.xpath("//span[contains(text(),'"+category_value+"')]//parent::div[@name='category']"));
       actions.moveToElement(catg).click().build().perform();
       actions.moveToElement(ele_Category).build().perform();
       actions.click(ele_Category).build().perform();
        }

    public void setStatus(String status_value)
    {

        Actions actions=new Actions(driver);
        WebElement ele_Status= driver.findElement(By.xpath("//span[contains(text(),'"+status_value+"')]//parent::div[@name='status']"));
        actions.moveToElement(status).click().build().perform();
        actions.moveToElement(ele_Status).build().perform();
        actions.click(ele_Status).build().perform();
    }

    public void setCompany(String company_value)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(companyName).build().perform();
        actions.sendKeys(company_value).build().perform();
    }
    public void setSource(String source_value)
    {

        Actions actions=new Actions(driver);
        WebElement ele_Source= driver.findElement(By.xpath("//span[contains(text(),'"+source_value+"')]//parent::div[@name='source']"));
        actions.moveToElement(source).click().build().perform();
        actions.moveToElement(ele_Source).build().perform();
        actions.click(ele_Source).build().perform();
    }

    public void validate_elements_Presence()
    {
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(txtFirstName.isDisplayed(),"first name element not Present");
        softAssert.assertTrue(txtLastName.isDisplayed(),"last name element not Present");
        softAssert.assertTrue(companyName.isDisplayed(),"company name element not Present");
        softAssert.assertTrue(position_field.isDisplayed(),"position element not Present");
        softAssert.assertTrue(source.isDisplayed(),"Source element not Present");
        softAssert.assertTrue(saveBtn.isDisplayed(),"Save btn element not Present");
        softAssert.assertAll();


    }

}
