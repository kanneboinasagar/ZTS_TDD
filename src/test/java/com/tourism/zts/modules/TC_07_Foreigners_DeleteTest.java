package com.tourism.zts.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.WebDriverUtilities;

public class TC_07_Foreigners_DeleteTest 

{
	WebDriver driver;
	@Test
	public void foreignersdelete() throws Exception
	{	
		driver=new ChromeDriver();
		//WebDriver driver=new ChromeDriver();
		WebDriverUtilities web=new WebDriverUtilities(driver);
		ReadData_PropFile r=new ReadData_PropFile();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		web.waitSynchro();
		//driver.manage().window().maximize();
		web.maximize();

		String url=r.readdatafrompropfile("url");
		String username=r.readdatafrompropfile("un");
		String password= r.readdatafrompropfile("pwd");

		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("form_submit")).click();

		driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
		driver.findElement(By.xpath("//a[@href='add-foreigners-ticket.php']")).click();
		driver.findElement(By.id("visitorname")).sendKeys("Johnny");
		driver.findElement(By.name("noadult")).sendKeys("1");
		driver.findElement(By.id("nochildren")).sendKeys("1");
		driver.findElement(By.name("submit")).click();
		//driver.switchTo().alert().accept();
		web.alertaccept();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
		driver.findElement(By.xpath("//a[@href='manage-foreigners-ticket.php']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[.='1']//following-sibling::td/a[.='Delete']")).click();
		
		//driver.switchTo().alert().accept();
		web.alertaccept();
		//driver.switchTo().alert().accept();
		web.alertaccept();
		
		
		driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
		driver.findElement(By.xpath("//span[.='Foreigners Ticket']/../following-sibling::ul//li/a[.='Manage Ticket']")).click();
		Thread.sleep(3000);
		String name=driver.findElement(By.xpath("//tr/../following-sibling::tbody")).getText();
		String Actualname="Johnny";
		if(name.equalsIgnoreCase(Actualname))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Name is not available");
		}
		driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[.='Log Out']")).click();

	}

}

