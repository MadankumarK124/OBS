package com.Online_Banking.Banking.GenericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = reports.createTest(MethodName);
		Reporter.log(MethodName + "-----Testscript execution started-----");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName + "--->Passed");
		Reporter.log(MethodName + "--->Script executed successfully----");

	}

	public void onTestFailure(ITestResult result) {
		String Failedscript = result.getMethod().getMethodName();
		String FScript = Failedscript + new Java_Utility().getSystemDateAndTimeINFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Base_Class.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot\\" + FScript + ".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName + "--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName + "--->testscript execution skipped");
	}

	public void onStart(ITestContext context) {
		// Executionstarts here
		// Configure the report
		// this is empty html page
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\report.html");
		htmlReport.config().setDocumentTitle("OBS Execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Online Banking System Execution report");

		// Setting All the system information
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base_Browser", "Chrome");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Base_url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
		reports.setSystemInfo("ReporterName", "Vivek Mishra");

	}

	public void onFinish(ITestContext context) {
		// Consolidate all the parameters and generate the report
		reports.flush();
	}

}
