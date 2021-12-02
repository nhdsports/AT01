package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import common.GlobalVariable;
import factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class LogHelper {

    WebDriver driver = DriverFactory.getDriver();

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest logger;

    private int NUM_OF_STEP = 0;

    /**
     * Create test log
     * @return
     */
    public void createExtent(String testName) {
        htmlReporter = GlobalVariable.getHtmlReporter();
        extent = GlobalVariable.getExtentReports();
        logger = extent.createTest(testName);
    }

    /**
     * Show step of test
     * @param nameStepTest
     */
    public void infoLog(String nameStepTest) {
        NUM_OF_STEP++;
        logger.log(Status.INFO, "<b>" + NUM_OF_STEP + ". " + nameStepTest + "</b>");
    }

    /**
     * Verify test case
     * @param verifyName
     * @param expected
     * @param actual
     */
    public void verifyTest(String verifyName, String expected, String actual) {
        if (expected.equalsIgnoreCase(actual)) {
            passLog(verifyName);
        }
        else {
            failLog(verifyName, expected, actual);
        }
    }
    public void verifyTest(String verifyName, boolean expected, boolean actual) {
        if (expected == actual) {
            passLog(verifyName);
        }
        else {
            failLog(verifyName);
        }
    }

    /**
     * Log when pass test
     * @param verifyName
     */
    public void passLog(String verifyName) {
        logger.log(Status.PASS, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:#00af00'>" + verifyName + "</span>");
    }

    /**
     * Log when fail test and take screenshot
     * @param verifyName
     */
    public void failLog(String verifyName, String expected, String actual) {
        try {
            String screenShotPath = screenCapture();
            logger.log(Status.FAIL, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:red'>" + verifyName + "</span>" +
                    "<ol>" +
                    "<li>Expected Result: " + expected + "</li>" +
                    "<li>Actual Result: " + actual + "</li>" +
                    "<li>Snapshot below:<br/><img src='" + screenShotPath + "' data-featherlight='" + screenShotPath + "' width='35%'/></li>" +
                    //"<li>Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath) + "</li>" +
                    "</ol>");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void failLog(String verifyName) {
        try {
            String screenShotPath = screenCapture();
            logger.log(Status.FAIL, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:red'>" + verifyName + "</span><br><img src='" + screenShotPath + "' data-featherlight='" + screenShotPath + "' width='35%'/>");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String screenCapture() throws IOException {
        String fileName = "sc-" + new Date().getTime();
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String pathImg = "test-output/ScreenCapture/" + fileName + ".png";
        String urlImg = "./ScreenCapture/" + fileName + ".png";
        File destination = new File(pathImg);
        FileUtils.copyFile(source, destination);
        return urlImg;
    }

    /**
     * Finish log test
     */
    public void flushExtent() {
        extent.flush();
    }

}
