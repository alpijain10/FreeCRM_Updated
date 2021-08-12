package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewContactsPage extends TestBase {

    @FindBy(xpath="//div[text() = \"Contacts\"]")
    WebElement contactslbl;
//
//    @FindBy(xpath="//div[contains(@class,'ui secondary')]/child::div[1]")
//    WebElement contactslbl;

    @FindBy(xpath = "//div[@name='view']")
    WebElement randomviewcontactelement;

     public ViewContactsPage(){
      PageFactory.initElements(driver,this);
  }

    public boolean verifyContactLabel()
    {
        System.out.println(contactslbl.getText());
        //randomviewcontactelement.click();
        return contactslbl.isDisplayed();
    }
}
