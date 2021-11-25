package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class LogHelper {

    WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest logger;

    int numOfStep = 0;

    /**
     * Create test log
     * @param driver
     * @param filePathExport
     * @param nameTestCase
     */
    public void createExtent(WebDriver driver, String filePathExport, String nameTestCase) {
        this.driver = driver;
        htmlReporter = new ExtentHtmlReporter(filePathExport);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        logger = extent.createTest(nameTestCase);
    }

    /**
     * Show step of test
     * @param nameStepTest
     */
    public void infoLog(String nameStepTest) {
        numOfStep++;
        logger.log(Status.INFO, "<b>" + numOfStep + ". " + nameStepTest + "</b>");
    }

    /**
     * Verify test case
     * @param verifyName
     * @param expected
     * @param actual
     * @param logPass
     * @param logFail
     */
    public void verifyTest(String verifyName, String expected, String actual, String logPass, String logFail) {
        if (expected.equalsIgnoreCase(actual)) {
            passLog(verifyName, logPass);
        }
        else {
            failLog(Status.FAIL, verifyName, logPass, logFail);
        }
    }
    public void verifyTest(String verifyName, boolean expected, boolean actual, String logPass, String logFail) {
        if (expected == actual) {
            passLog(verifyName, logPass);
        }
        else {
            failLog(Status.FAIL, verifyName, logPass, logFail);
        }
    }

    /**
     * Log when pass test
     * @param verifyName
     * @param logPass
     */
    public void passLog(String verifyName, String logPass) {
        logger.log(Status.PASS, "<span style='color:#00af00'>" + verifyName + "</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + logPass);
    }

    /**
     * Log when fail test and take screenshot
     * @param status
     * @param verifyName
     * @param logPass
     * @param logFail
     */
    public void failLog(Status status, String verifyName, String logPass, String logFail) {
        try {
            String screenShotPath = screenCapture();
            logger.log(status, "<span style='color:red'>" + verifyName + "</span>" +
                    "<ol>" +
                    "<li>Expected Result: " + logPass + "</li>" +
                    "<li>Actual Result: " + logFail + "</li>" +
                    "<li>Snapshot below:<br/><img src='" + screenShotPath + "' data-featherlight='" + screenShotPath + "' width='35%'/></li>" +
                    //"<li>Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath) + "</li>" +
                    "</ol>");
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
     * Error run test log
     */
    public void errorRunTest(Exception e) {
        logger.log(Status.FAIL, "<span style='color:red'>Run test error!</span><br>" + e);
    }

    /**
     * Finish log test
     */
    public void flushExtent() {
        extent.flush();
    }

}
