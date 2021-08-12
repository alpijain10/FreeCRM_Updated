package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage extends TestBase {

    @FindBy(xpath = "//div[text()='Create new Task']")
    WebElement lblTask;

    @FindBy(xpath = "//input[@name='title']")
    WebElement taskname;

    @FindBy(xpath="//div[@name='type' and @role='listbox']")
    WebElement type;

    @FindBy(xpath = "//span[text()='Customer Support']")
    WebElement type_option;

    @FindBy(xpath="//label[text()=\"Assigned To\"]//following::div[1]")
    WebElement assignedTo;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement Savebtn;

    @FindBy(xpath = "//div[@name='deal']/preceding::input[1]")
    WebElement contact;

    @FindBy(xpath = "//div[@name='type' and @role='listbox']/following::input[1]")
    WebElement due_date;

    @FindBy(xpath = "//div[@name='case' and @role='combobox']/following::input[1]")
    WebElement close_date;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement desc_task;

    @FindBy(xpath = "//div[@name='contact']/following::input[1]")
    WebElement deal;

    @FindBy(xpath = "//label[text()='Tags']/following::input[1]")
    WebElement tag;

    @FindBy(xpath = "//label[text()='Case']/following::input[1]")
    WebElement case1;

    @FindBy(xpath = "//label[text()='Identifier']/following::input[1]")
    WebElement identifier;

    @FindBy(xpath = "//input[@name='completion']")
    WebElement completion_field;

    @FindBy(xpath = "//input[@name='completion']//following::div[@role='listbox'][1]")
    WebElement priority_field;

    public TaskPage()
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyTaskPageheader()
    {
        return lblTask.isDisplayed();
    }

    public SaveTaskPage addNewTaskData(String Title,String AssignedTo,String Type,String DueDate,String Contact,String Deal,String Case,String CloseDate,String Tags,String Description,String Completion,String Priority,String Status,String Identifier)
    {
     String valueOfType=Type;
     Actions action= new Actions(driver);
     taskname.sendKeys(Title);
     action.moveToElement(assignedTo).build().perform();
     assignedTo.sendKeys(AssignedTo);
     type.click();
     //WebElement eletype= driver.findElement(By.xpath("//div[@name='type'and @role='listbox']//span[text()='+"valueOfType"+']"));
     //eletype.click();
     action.moveToElement(due_date).build().perform();
     due_date.sendKeys(DueDate);
     contact.sendKeys(Contact);
     deal.sendKeys(Deal);
     case1.sendKeys(Case);
     close_date.sendKeys(CloseDate);
     tag.sendKeys(Tags);
     desc_task.sendKeys(Description);
     completion_field.sendKeys(Completion);
     identifier.sendKeys(Identifier);
     Savebtn.click();
     return new SaveTaskPage();

    }

}
