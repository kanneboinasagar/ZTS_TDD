package com.tourism.zts.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result)
	{
	   String time=new Date().toString().replace(":","_").replace(" ","_");
	   
	   String testname=result.getMethod().getMethodName();
	   
//		EventFiringWebDriver ef=new EventFiringWebDriver(BaseClass.sdriver);
//		File src=ef.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshot/"+testname+time+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}

	}
