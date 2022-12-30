package com.tourism.xmlpractice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlTest 
{
	@Test
	public void readDataFromXml(XmlTest xml) // we need to pass argument for XMl
		{
	 String URL=xml.getParameter("url");
		System.out.println(URL);
		
		String un1=xml.getParameter("un");
		System.out.println(un1  );
		
	} 

}




