package com.tourism.zts.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.WebDriverUtilities;

public class TC_06_ForeignersTicketTest 
{
	WebDriver driver;
	@Test
	public void foreigners() throws Exception
	{	
		driver=new ChromeDriver();
	
		WebDriverUtilities web=new WebDriverUtilities(driver);
	ReadData_PropFile r=new ReadData_PropFile();
	String url=r.readdatafrompropfile("url");
	String username=r.readdatafrompropfile("un");
	String password=r.readdatafrompropfile("pwd");
	driver.get(url);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	web.waitSynchro();
	//driver.manage().window().maximize();
     web.maximize();
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.id("form_submit")).click();
	
	driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
	driver.findElement(By.xpath("//a[@href='add-foreigners-ticket.php']")).click();
	driver.findElement(By.id("visitorname")).sendKeys("Dwyane Johnson");
	driver.findElement(By.name("noadult")).sendKeys("1");
	driver.findElement(By.id("nochildren")).sendKeys("1");
	driver.findElement(By.name("submit")).click();
	//driver.switchTo().alert().accept();
	web.alertaccept();
	 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
	driver.findElement(By.xpath("//a[@href='manage-foreigners-ticket.php']")).click();
	Thread.sleep(1000);
	String name=driver.findElement(By.xpath("//td[.='Dwyane Johnson']")).getText();
	String actualname="Dwyane Johnson";
	if(name.equalsIgnoreCase(actualname))
	{
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}
	driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
	driver.findElement(By.xpath("//a[.='Log Out']")).click();
	}
}
