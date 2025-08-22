package ninjaCRM.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class is implements ITestListerner
 * @author Gangineni Lokesh
 */
public class ListernersImplementation implements ITestListener {

	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println("========test execution is started========");
		
		//intimate report for test report start
		 test = report.createTest(methodName);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"========test execution is success========");
		test.log(Status.PASS, methodName+"========test execution is success========");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"==========execution failed==========");
		
		//log the status as fail in extent report
		test.log(Status.FAIL, methodName+"==========execution failed==========");
		
		//log the execption in extent reports
		test.log(Status.INFO, result.getThrowable());
		
		//capture execption
		System.out.println(result.getThrowable());
		
		//capture the screenshot
		JavaUtility jutil= new JavaUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		//                    method name + date n time
		String screenshotName=methodName+jutil.GettingDate();
		
		try {
			
			
			String path = wutil.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//add screen capture the path
			test.addScreenCaptureFromPath(path);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().toString();
		System.out.println(methodName+"==========execution skipped==========");
		System.out.println(result.getThrowable());
		
		//log skip status
		test.log(Status.SKIP, methodName+"==========execution skipped==========");
		
		
		test.log(Status.WARNING,result.getThrowable())	;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---------------------execution is started---------------------------");
		ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReports\\Extent-Report-"+new JavaUtility().GettingDate()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation execution Report");
		
		 report =new  ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Google Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base url", "Test Env");
		report.setSystemInfo("Reporter name", "Lokesh");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("--------------------execution is started-----------------------");
		
		//report generation
		report.flush();
	}
		

}
