package com.tourism.zts.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import objectrepository.HomePage;
import objectrepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	//public static WebDriver sdriver;
	public WebDriverUtilities wUtil;
	public ReadData_PropFile r=new ReadData_PropFile();

	@Parameters("browser")
	@BeforeClass(groups={"smoke","regression"})
	//public void launchBrowser() {
	public void lauchBrowser(String browser)
	{
		if(browser.equals("chrome"))

		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
	  //  driver=new ChromeDriver();
		wUtil=new WebDriverUtilities(driver);
		wUtil.maximize();
		//sdriver=driver;
       
	}

	@BeforeMethod(groups={"smoke","regression"})
	public void login() throws Exception
	{

		String url=r.readdatafrompropfile("url");
		String username= r.readdatafrompropfile("un");
		String password=r.readdatafrompropfile("pwd");
		driver.get(url);
		wUtil.waitSynchro();
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(username, password);
	}


	@AfterMethod(groups={"smoke","regression"})
	public void logout()
	{
		HomePage hm=new HomePage(driver);
		hm.getLogout().click();
	}

	@AfterClass(groups={"smoke","regression"})
	public void closeBrowser()
	{
		driver.close();
	}

}
