package com.tourism.zts.modules;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tourism.zts.generic.BaseClass;
import com.tourism.zts.generic.ReadData_Excel;
import com.tourism.zts.generic.TestDataCreation;

import objectrepository.AddAnimalPage;
import objectrepository.HomePage;
import objectrepository.ManageTypeTicket;


@Listeners(com.tourism.zts.generic.ListenerImp.class)
public class TC_001_TestNG_TC_02_03Test extends BaseClass
{
		
		@Test(groups= {"smoke"})
		public void addanimal() throws Exception
		{
            // System.out.println("Smoke testing under execution");

			ReadData_Excel rde=new ReadData_Excel();
			TestDataCreation td=new TestDataCreation();

			Thread.sleep(3000);
			
			HomePage hm=new HomePage(driver);
			hm.getAnimalDetails().click();
			hm.getAdd_Animal().click();


			String Animalname=rde.readdatafromexcel("Sheet1", 1, 0)+td.random();
			String Cagenumber=rde.readdatafromexcel("Sheet1", 1, 1)+td.getCageno();
			String feednumber=rde.readdatafromexcel("Sheet1", 1, 2)+td.getFeedno();
			String Breed=rde.readdatafromexcel("Sheet1", 1, 3);
			String Desc=rde.readdatafromexcel("Sheet1", 1, 4);	

			AddAnimalPage aap=new AddAnimalPage(driver);
			aap.getAnimalName().sendKeys(Animalname);
			Thread.sleep(2000);
			driver.findElement(By.id("image")).sendKeys("C:\\Users\\user\\Desktop\\Desktop\\download.jpeg");
			aap.getCageNo().sendKeys(Cagenumber);
			aap.getFeedno().sendKeys(feednumber);
			aap.getBreed().sendKeys(Breed);
			aap.getDescription().sendKeys(Desc);
			aap.getSubButton().click();
           
			

	       driver.switchTo().alert().accept();

			hm.getAnimalDetails().click();
			hm.getManage_Animals().click();

			String name1=driver.findElement(By.xpath("//td[text()='"+Animalname+"("+Breed+")"+"']")).getText();
			String Actualname=Animalname+"("+Breed+")";
			if(name1.equalsIgnoreCase(Actualname))
			{ 
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test Failed");
			}

			hm.getAdmin().click();
			Thread.sleep(2000);
			hm.getLogout().click();

		}
		
		
		@Test(groups= {"regression"})
		public void manageticket() throws Exception
		{
			 //System.out.println("Regression testing under execution");
			ReadData_Excel rde=new ReadData_Excel();
			TestDataCreation tc=new TestDataCreation();

			
			String price1=rde.readdatafromexcel("Sheet2", 1, 0)+tc.getprice();


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

			driver.switchTo().alert().accept();
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
