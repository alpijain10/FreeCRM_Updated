package com.crm.qa.base;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//Parent Class
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static String driverpath;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:/Users/nisha/IdeaProjects/FreeCRM_Updated/src/main/java/com/crm" + "/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void initialization() {
        String Browsername = prop.getProperty("browser");
        String username=prop.getProperty("username");
        System.out.println(Browsername);
        System.out.println(username);

        if(Browsername.equalsIgnoreCase("chrome"))
        {
            driverpath=TestUtil.driverPath + "/ChromeDriver/chromedriver.exe";
            System.out.println("Launching chrome");
            System.setProperty("webdriver.chrome.driver",driverpath);
            driver=new ChromeDriver();
        }
        if (Browsername.equalsIgnoreCase("IE")) {
            System.out.println("Launching IE");
            driverpath = TestUtil.driverPath + "/Microsoft Edge/MicrosoftWebDriver.exe";
            System.setProperty("webdriver.edge.driver", driverpath);
            driver = new EdgeDriver();
        }
        if (Browsername.equalsIgnoreCase("firefox")) {
            System.out.println("Launching Firefox");
            driverpath="C:\\Program Files\\selenium-java-3.14\\Drivers\\GeckoDriver\\geckodriver.exe";
            //driverpath = TestUtil.driverPath + "/GeckoDriver/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", driverpath);
            driver = new FirefoxDriver();
        }

        JavascriptExecutor js=(JavascriptExecutor)driver;
        e_driver=new EventFiringWebDriver(driver);
        //Now create object of EventListenerhandler to register it with EventFiringebDriver
        eventListener=new WebEventListener();
        e_driver.register(eventListener);
        driver=e_driver;

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));

        }

    }







