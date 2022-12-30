package com.tourism.zts.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tourism.zts.generic.ReadData_Excel;
import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.TestDataCreation;
import com.tourism.zts.generic.WebDriverUtilities;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.ManageTypeTicket;

public class TC_03_ManageTypeTicketTest 
{
	WebDriver driver;
	@Test
	public void manageticket() throws Exception
	{
		driver=new ChromeDriver();
		WebDriverUtilities web=new WebDriverUtilities(driver);

		ReadData_PropFile r = new ReadData_PropFile();
		ReadData_Excel rde=new ReadData_Excel();
		TestDataCreation tc=new TestDataCreation();

		String url=r.readdatafrompropfile("url");
		String username=r.readdatafrompropfile("un");
		String password=r.readdatafrompropfile("pwd");
		String price1=rde.readdatafromexcel("Sheet2", 1, 0)+tc.getprice();

		driver.get(url);
		web.waitSynchro();	
		web.maximize();

		LoginPage lp=new LoginPage(driver);
		lp.LoginApp(username, password);

		Thread.sleep(3000);

		ManageTypeTicket mt=new ManageTypeTicket(driver);
		mt.getManageTypeTicket().click();
		mt.getEdit().click();
		Thread.sleep(2000);
		mt.getPrice().clear();
		Thread.sleep(2000);
		mt.getPrice().sendKeys(price1);
		mt.getSubButton().click();
		Thread.sleep(2000);

		web.alertaccept();
		mt.getManageTypeTicket().click();

		String price=driver.findElement(By.xpath("//td[.=' $ "+price1+"']")).getText();

		String Actualprice= "$"+" "+price1  ;
		if(price.equals(Actualprice))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}	
		HomePage hm =new HomePage(driver);
		hm.getAdmin().click();
		hm.getLogout().click();

	}
}


//WebDriver driver=new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.manage().window().maximize();
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.id("form_submit")).click();


//driver.findElement(By.xpath("//a[@href='manage-ticket.php']")).click();
//driver.findElement(By.xpath("//a[@href='edit-ticket.php?editid=1']")).click();
//driver.findElement(By.id("tprice")).clear();
//Thread.sleep(2000);
//driver.findElement(By.id("tprice")).sendKeys(price1);
//
//Thread.sleep(3000);
//driver.findElement(By.name("submit")).click();
//
////driver.switchTo().alert().accept();

//driver.findElement(By.xpath("//a[@href='manage-ticket.php']")).click();

//driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
//driver.findElement(By.xpath("//a[.='Log Out']")).click();










