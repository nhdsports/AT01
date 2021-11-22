package page;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import helper.ElementHelper;

public class BasePage {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    ElementHelper ws = new ElementHelper();

    public void createExtent(String nameTestCase) {
        htmlReporter = new ExtentHtmlReporter("test-output/RegisterReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest(nameTestCase);
    }

    public void infoTest(String nameStepTest){
        test.log(Status.INFO, nameStepTest);
    }

    public void passTest(){
        test.log(Status.PASS, "Success! The step is pass");
    }

    public void failTest(){
        test.log(Status.FAIL, "Fail! The step is fail");
    }

    public void skipTest(){
        test.log(Status.SKIP,"Skipping! This is not ready for testing");
    }

    public void warningTest(){
        test.log(Status.WARNING,"Warning!");
    }

    public void flushExtent() {
        extent.flush();
    }

}
