package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //PageFactory-OR
    @FindBy(name="email")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//div[contains(@class ,'submit')]")
    WebElement loginBtn;

    @FindBy(xpath ="//a[text()=\"Sign Up\"]")
    WebElement signuplink;

    @FindBy(xpath = "//span[text()='Settings']//preceding::i[2]")
    WebElement settings;

    @FindBy(xpath = "//span[text()=\"Log Out\"]")
    WebElement logOut;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);

    }
    //Actions
    public String validationLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validatesignuplinkdisplay()
    {
        return signuplink.isDisplayed();
            }

    public HomePage login(String un,String pwd)
    {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }
    public void logout()
    {
        Actions action=new Actions(driver);
        action.moveToElement(settings).click();
        action.moveToElement(logOut).click();
        action.build().perform();
        System.out.println("Logged OUT");

    }

}
