package com.tourism.xmlpractice;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJsonFileTest 

{
	@Test
		public void readDataFromJsonFile() throws Exception
		{
		
		//Step-1: Convert JSON file to JSON Object
		FileReader fr=new FileReader("../SDET11_SAG/Data/CommonData.json");
		
		//Step-2 Convert JSON Object to Java Object
		JSONParser json=new JSONParser();
		Object jobj=json.parse(fr);
		 
		
		//Step-3 read the data using HashMap
		
		HashMap hp=(HashMap)jobj;
		String URL=(String) hp.get("url");
		System.out.println(URL);	
		}
	
	}

