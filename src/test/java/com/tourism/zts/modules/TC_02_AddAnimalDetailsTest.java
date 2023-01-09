package com.tourism.zts.modules;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.tourism.zts.generic.BaseClass;
import com.tourism.zts.generic.ReadData_Excel;
import com.tourism.zts.generic.TestDataCreation;
import objectrepository.AddAnimalPage;
import objectrepository.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Listeners(com.tourism.zts.generic.ListenerImp.class)
public class TC_02_AddAnimalDetailsTest extends BaseClass
{
	
	@Test
	public void addanimal() throws Exception
	{

		

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

		String name1=driver.findElement(By.xpath("//td[text()='"+Animalname+"("+Breed+")"+"']")).getText()+"cchjvv";
		String Actualname=Animalname+"("+Breed+")";
        
		Assert.assertEquals(name1, Actualname);

		hm.getAdmin().click();
		Thread.sleep(2000);

		 
	}
}


//driver=new ChromeDriver();
//WebDriverUtilities web=new WebDriverUtilities(driver);
//ReadData_PropFile r=new ReadData_PropFile();

//String url=r.readdatafrompropfile("url");
//String username= r.readdatafrompropfile("un");
//String password=r.readdatafrompropfile("pwd");


//driver.get(url);

//web.waitSynchro(); 
//
//web.maximize();    
//Thread.sleep(3000);

//LoginPage lp=new LoginPage(driver);
//lp.LoginApp(username, password);


//WebDriver driver=new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.manage().window().maximize();
//driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.id("form_submit")).click();
//driver.findElement(By.xpath("//span[text()='Animals Details']")).click();
//driver.findElement(By.xpath("//a[text()='Add Animals']")).click();


//		driver.findElement(By.id("aname")).sendKeys(Animalname);
//		Thread.sleep(3000);
//		driver.findElement(By.id("image")).sendKeys("C:\\Users\\user\\Desktop\\Desktop\\download.jpeg");
//		Thread.sleep(5000);
//		driver.findElement(By.id("cnum")).sendKeys(Cagenumber);
//		driver.findElement(By.id("fnum")).sendKeys(feednumber);
//		driver.findElement(By.id("breed")).sendKeys(Breed);
//		driver.findElement(By.id("desc")).sendKeys(Desc);
//		driver.findElement(By.name("submit")).click();
//
//
//		//driver.switchTo().alert().accept();
//		web.alertaccept();
//
//		driver.findElement(By.xpath("//span[text()='Animals Details']")).click();
//		driver.findElement(By.xpath("//a[text()='Manage Animals']")).click();
//		String name1=driver.findElement(By.xpath("//td[text()='"+Animalname+"("+Breed+")"+"']")).getText();
//		String Actualname=Animalname+"("+Breed+")";
//
//
//		if(name1.equalsIgnoreCase(Actualname))
//		{ 
//			System.out.println("Test passed");
//		}
//		else
//		{
//			System.out.println("Test Failed");
//		}
//
//		driver.findElement(By.xpath("//h4[@data-toggle='dropdown']")).click();
//		driver.findElement(By.xpath("//a[.='Log Out']")).click();
//hm.getLogout().click();
//if(name1.equalsIgnoreCase(Actualname))
//{ 
//	System.out.println("Test passed");
//}
//else
//{
//	System.out.println("Test Failed");
//}
