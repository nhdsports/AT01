package factory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import common.GlobalVariable;
import helper.LogHelper;

public class LoggerFactory {

    public static ThreadLocal<LogHelper> loggers = new ThreadLocal<>();

    public static void setLogger(LogHelper logger) {
        loggers.set(logger);
    }

    public static LogHelper getLogger() {
        return loggers.get();
    }

    public static void setUp(String fileNameHTMLReport) {
        GlobalVariable.setHtmlReporter(new ExtentHtmlReporter("test-output/" + fileNameHTMLReport + ".html"));
        GlobalVariable.setExtentReports(new ExtentReports());
        GlobalVariable.getExtentReports().attachReporter(GlobalVariable.getHtmlReporter());
    }
}
