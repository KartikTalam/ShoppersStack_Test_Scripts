package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " TEST EXECUTION STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " FAILED");
		System.out.println("FAILED DUE TO : "+result.getThrowable());
		
		JavaUtility ju = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)(BaseClass.sdriver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot"+result.getMethod().getMethodName()+"_"+ju.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName() + "SKIPPED");
		System.out.println("SKIPPED DUE TO : "+result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("SUITE EXECUTION STARTED");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("SUITE EXECUTION FINISHED");
	}

}
