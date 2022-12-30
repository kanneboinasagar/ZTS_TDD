package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Workbook2
{ //Read  a particular data from excel
    @Test
    public void work() throws Exception
    {
	//public static void main(String[] args) throws Exception 
		FileInputStream f=new FileInputStream("D:\\Selenium\\Excel.xlsx");
		String s=WorkbookFactory.create(f).getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		System.out.println(s);	
		
	}

}
