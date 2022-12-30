package com.tourism.zts.modules;

import org.testng.annotations.Test;

import com.tourism.zts.generic.ReadData_Excel;
import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.TestDataCreation;
import com.tourism.zts.generic.WebDriverUtilities;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.NormalTicket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_05_NormalTicket_deleteTest 
{
	WebDriver driver;
	@Test
	public void normalticket() throws Exception
	{

		driver=new ChromeDriver();
		WebDriverUtilities web=new WebDriverUtilities(driver);
		ReadData_PropFile r=new ReadData_PropFile();
		String url=r.readdatafrompropfile("url");
		String username=r.readdatafrompropfile("un");
		String password=r.readdatafrompropfile("pwd");

		ReadData_Excel rde=new ReadData_Excel();
		TestDataCreation td=new TestDataCreation();
		String visitorname=rde.readdatafromexcel("Sheet3", 1, 0);
		String noOfAdult=rde.readdatafromexcel("Sheet3", 1, 1)+td.getNoOfAdult();
		String noOfChild=rde.readdatafromexcel("Sheet3", 1, 2)+td.getNoOfChild();

		driver.get(url);
		web.waitSynchro();
		web.maximize();

		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(username, password);

		HomePage hm=new HomePage(driver);
		hm.getNormalTicket().click();
		hm.getAddTicket().click();

		NormalTicket nt=new NormalTicket(driver);
		nt.getVisitorname().sendKeys(visitorname);
		nt.getNoadult().sendKeys(noOfAdult);
		nt.getNochildren().sendKeys(noOfChild);
		Thread.sleep(3000);
		nt.getSubButton().click();

		web.alertaccept();

		hm.getNormalTicket().click();
		hm.getManageTicket().click();
		Thread.sleep(3000);
		nt.getDelete().click(); 
		web.alertaccept();

		web.alertaccept();


		String name=driver.findElement(By.xpath("//td[contains(.,'"+visitorname+"')]")).getText();		
		String actualname=visitorname;
		try {
			if(name.equalsIgnoreCase(actualname))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception is handled");
		}

		hm.getAdmin().click();;
		hm.getLogout().click();

	}

}

//WebDriver driver=new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.manage().window().maximize();
//driver.switchTo().alert().accept();

//
//driver.findElement(By.id("username")).sendKeys(username);
//driver.findElement(By.name("password")).sendKeys(password);
//driver.findElement(By.id("form_submit")).click();
//driver.findElement(By.xpath("//span[.='Normal Ticket']")).click();
//driver.findElement(By.xpath("//span[text()='Normal Ticket']")).click();
//driver.findElement(By.xpath("//a[@href='add-normal-ticket.php']")).click();
//driver.findElement(By.id("visitorname")).sendKeys("Will Smith");
//driver.findElement(By.id("noadult")).sendKeys("1");
//driver.findElement(By.id("nochildren")).sendKeys("1");
//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath("//span[text()='Normal Ticket']")).click();
//driver.findElement(By.xpath("//a[@href='manage-normal-ticket.php']")).click();
//driver.findElement(By.xpath("//td[.='1']//following-sibling::td/a[.='Delete']")).click();
//driver.switchTo().alert().accept();
//driver.switchTo().alert().accept();
//driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
//driver.findElement(By.xpath("//a[.='Log Out']")).click();
