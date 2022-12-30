package com.tourism.zts.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tourism.zts.generic.ReadData_Excel;
import com.tourism.zts.generic.ReadData_PropFile;
import com.tourism.zts.generic.WebDriverUtilities;

public class TC_08_AddAnimals_EditTest
{
	WebDriver driver;
	@Test
	public void edit() throws Exception
	{
		driver=new ChromeDriver();
		WebDriverUtilities web=new WebDriverUtilities(driver);
		ReadData_PropFile r=new ReadData_PropFile();
		ReadData_Excel rde=new ReadData_Excel();
		String edit=rde.readdatafromexcel("Sheet4", 0, 0);
		String url=r.readdatafrompropfile("url");
		String username=r.readdatafrompropfile("un");
		String password=r.readdatafrompropfile("pwd");
		
		
		driver.get(url);
		web.waitSynchro();
		web.maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("form_submit")).click();
      
		driver.findElement(By.xpath("//span[text()='Animals Details']")).click();
		driver.findElement(By.xpath("//a[.='Manage Animals']")).click();
		
		driver.findElement(By.xpath("//td[.='1']/../td/a[.='Edit']")).click();
		Thread.sleep(2000);
		String AnimalName=driver.findElement(By.xpath("//input[@value='White Tiger64']")).getAttribute("value");
		
		driver.findElement(By.id("breed")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("breed")).sendKeys(edit);
		driver.findElement(By.name("submit")).click();
		web.alertaccept();
		
		driver.findElement(By.xpath("//span[text()='Animals Details']")).click();
		driver.findElement(By.xpath("//a[.='Manage Animals']")).click();
		
		
		
		String name=driver.findElement(By.xpath("//td[.='White Tiger64(Natural Breed)']")).getText();
		String actualbreed=AnimalName+"("+edit+")";
		System.out.println(AnimalName);
		System.out.println(actualbreed);
		if(name.equalsIgnoreCase(actualbreed))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[.='Log Out']")).click();
	}

}
