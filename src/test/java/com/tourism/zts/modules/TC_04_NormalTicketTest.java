package com.tourism.zts.modules;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tourism.zts.generic.BaseClass;
import com.tourism.zts.generic.ReadData_Excel;
import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.TestDataCreation;
import com.tourism.zts.generic.WebDriverUtilities;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.NormalTicket;

public class TC_04_NormalTicketTest extends BaseClass
{    
	
	@Test
	public void normalticket() throws Exception
	{

		ReadData_Excel rde=new ReadData_Excel();
		TestDataCreation td=new TestDataCreation();
		String visitorname=rde.readdatafromexcel("Sheet3", 1, 0);
		String noOfAdult=rde.readdatafromexcel("Sheet3", 1, 1)+td.getNoOfAdult();
		String noOfChild=rde.readdatafromexcel("Sheet3", 1, 2)+td.getNoOfChild();
		HomePage hm=new HomePage(driver);
		hm.getNormalTicket().click();
		hm.getAddTicket().click();

		NormalTicket nt=new NormalTicket(driver);
		nt.getVisitorname().sendKeys(visitorname);
		nt.getNoadult().sendKeys(noOfAdult);
		nt.getNochildren().sendKeys(noOfChild);
		Thread.sleep(3000);
		nt.getSubButton().click();

		driver.switchTo().alert().accept();

		hm.getNormalTicket().click();
		hm.getManageTicket().click();


		String name=driver.findElement(By.xpath("//tr[@data-expanded='true']//td[.='"+visitorname+"']")).getText();

		String Actualname=visitorname;
		Assert.assertEquals(name, Actualname);
		
		Thread.sleep(2000);
		hm.getAdmin().click();
		
	}	


}
//WebDriver driver=new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.manage().window().maximize();
//driver.switchTo().alert().accept();
//String name=driver.findElement(By.xpath("//td[.='Will Smith']")).getText();
//driver.findElement(By.id("username")).sendKeys(username);
//driver.findElement(By.name("password")).sendKeys(password);
//driver.findElement(By.id("form_submit")).click();

//driver.findElement(By.xpath("//span[text()='Normal Ticket']")).click();
//driver.findElement(By.xpath("//a[@href='add-normal-ticket.php']")).click();
//driver.findElement(By.id("visitorname")).sendKeys(visitorname);
//driver.findElement(By.id("noadult")).sendKeys(noOfAdult);
//driver.findElement(By.id("nochildren")).sendKeys(noOfChild);

//driver.findElement(By.name("submit")).click();
//driver.findElement(By.xpath("//span[text()='Normal Ticket']")).click();
//driver.findElement(By.xpath("//a[@href='manage-normal-ticket.php']")).click();
//driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
//driver.findElement(By.xpath("//a[.='Log Out']")).click();
//if(name.equalsIgnoreCase(Actualname))
//{
//	System.out.println("Test Passed");
//}
//else
//{
//	System.out.println("Test Failed");
//}