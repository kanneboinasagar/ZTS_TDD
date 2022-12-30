package pratice;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1
{
	public static void main(String[] args) throws Exception {
		
	
	//public void demo() throws InterruptedException
	
	Date d =new Date();
	System.out.println(d);
	
	String date_and_month=d.toString();
	String[] s=date_and_month.split(" "); 
		
	String day= s[0];
	String month=s[1];
	String date=s[2];
	String year=s[5];
	
	String currentdate=day+" "+month+" "+date+" "+year;
	System.out.println(currentdate);
	

		
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@aria-label='"+ currentdate+"']")).click();
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH,1);
	cal.getTime();
	
	
	
	
	
	
	
	}		

}
