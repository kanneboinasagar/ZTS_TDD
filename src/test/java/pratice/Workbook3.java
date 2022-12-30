package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Workbook3
{
 //write data in excel sheet
	public static void main(String[] args) throws Exception 
	{
		FileInputStream f=new FileInputStream("D:\\Selenium\\Excel.xlsx");
		Workbook w =WorkbookFactory.create(f);
		Sheet s =w.createSheet("Sheet2");
	    
		s.createRow(0).createCell(0).setCellValue("Sagar");
         
		FileOutputStream fo=new FileOutputStream("D:\\Selenium\\Excel.xlsx");
		
	    w.write(fo);
	    fo.close();
	    w.close();
		
		
		
		
		
	}

}
