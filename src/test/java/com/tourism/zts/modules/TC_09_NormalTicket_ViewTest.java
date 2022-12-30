package com.tourism.zts.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.WebDriverUtilities;

import objectrepository.LoginPage;

public class TC_09_NormalTicket_ViewTest 
{

	WebDriver driver;
	@Test
	public void view() throws Exception
	{
		
		
		driver=new ChromeDriver();
		WebDriverUtilities web =new WebDriverUtilities(driver);
		ReadData_PropFile r=new ReadData_PropFile();
		String url=r.readdatafrompropfile("url");
		String username=r.readdatafrompropfile("un");
		String password=r.readdatafrompropfile("pwd");

		driver.get(url);
		web.waitSynchro();
		web.maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(username, password);
	
//		
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.id("form_submit")).click();
//
//		driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
//		driver.findElement(By.xpath("//a[@href='manage-foreigners-ticket.php']")).click();
//		driver.findElement(By.xpath("//td[.='1']/../descendant::td/a[.='View']")).click();
//		driver.findElement(By.xpath("//i[@style='cursor: pointer;']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
//		driver.findElement(By.xpath("//a[.='Log Out']")).click();
//

	}
}
