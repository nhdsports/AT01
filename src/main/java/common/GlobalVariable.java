package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import lombok.Getter;
import lombok.Setter;

public class GlobalVariable {

    @Getter
    @Setter
    private static ExtentTest extentTest;

    @Getter
    @Setter
    private static ExtentReports extentReports;

    @Getter
    @Setter
    private static ExtentHtmlReporter htmlReporter;

}
