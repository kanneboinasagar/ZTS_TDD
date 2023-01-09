package com.tourism.xmlpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Browser_commandpromptTest 
{
	@Test
	public static void m1()
	{
		WebDriver driver=null;
		String prop=System.getProperty("browser");
		System.out.println(prop);
		if(prop.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.get("https://www.facebook.com/");
	}

}
