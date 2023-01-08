package com.mystore.utilities;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mystore.testcases.BaseClass;

public class ItestListnerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
	
			CaptureScreenshots(result.getMethod().getMethodName()+".jpg");

		}
			
	}
	
	


