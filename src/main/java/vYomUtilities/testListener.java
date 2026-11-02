package vYomUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import vYomBase.BaseClass;

public class testListener extends BaseClass implements ITestListener {

    ExtentReports extent = extentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Listener Started : " + result.getName());

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String path = screenshotUtility.captureScreenshot(
                driver,
                result.getName(),
                "Pass");

        test.pass("Test Passed");
        test.addScreenCaptureFromPath(path);

        System.out.println("Test Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = screenshotUtility.captureScreenshot(
                driver,
                result.getName(),
                "Fail");

        test.fail(result.getThrowable());
        test.addScreenCaptureFromPath(path);

        System.out.println("Test Failed : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");

        System.out.println("Test Skipped : " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Extent Report Generated Successfully");
    }
}