package com.crm.qa.ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExtentReportNew {

    public static Log log= LogFactory.getLog(ExtentReportNew.class);
    public static void main(String[] args) {
        ExtentHtmlReporter report = new ExtentHtmlReporter("C:\\Users\\nisha\\IdeaProjects\\FreeCRM_Updated\\src\\main\\resources\\Report\\ExecutionReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(report);
        ExtentTest parentTest = extent.createTest("TC01- Verify PageTitle");
        ExtentTest childTest=parentTest.createNode("Go to freecrm site");
        parentTest.createNode("Enter username /password");
        extent.setSystemInfo("OS","Windows 10");
        ExtentTest node = parentTest.createNode("Page Title");
        node.log(Status.PASS, "Page Title correctly displayed");
        parentTest = extent.createTest("TC02- Validate signup link");
        parentTest.createNode("Sign up link display");
        extent.flush();
        log.info("This is my log4j test");
    }



}
