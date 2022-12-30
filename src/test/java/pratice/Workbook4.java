package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Workbook4
{
 //Read all data from excel
	public static void main(String[] args) throws Exception 
	{
		FileInputStream f=new FileInputStream("D:\\Selenium\\Excel.xlsx");
		Workbook w =WorkbookFactory.create(f);
		Sheet s =w.getSheet("Sheet1");
		
		
	}

}
