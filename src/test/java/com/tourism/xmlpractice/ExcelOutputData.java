package com.tourism.xmlpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
                                                       
public class ExcelOutputData 
{
	Row r;
	Cell c;
  @Test
	public void output() throws Exception
	{
		FileInputStream f=new FileInputStream("../SDET11_SAG/Data/Exceldata.xlsx");
	Workbook w=	WorkbookFactory.create(f);
	//w.createSheet("Sheet7").createRow(0).createCell(0).setCellValue("TOM");

	
	     FileOutputStream fo=new FileOutputStream("../SDET11_SAG/Data/Exceldata.xlsx");
	     w.write(fo);
	     	
	     
	     Sheet s= w.createSheet("Sheet8");
	     
	     for(int row=0;row<=5;row++)
	     {
	    	 s.createRow(row);    	 
	     }
	     
	     for(int cell=0;cell<=5;cell++)
	     {
	     r.createCell(cell);
	     }
	     
	     c.setCellValue("Sagar");
	     
	     
	     
	     
	     
	     
         
	    
	    
	     
 	    
	    
	    
	    
	}
}
	     
