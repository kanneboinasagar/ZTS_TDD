package com.tourism.zts.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadData_PropFile 
{
	public String readdatafrompropfile(String key) throws Exception
	{
		FileInputStream f=new FileInputStream(IAutoConstants.filepath1);
		Properties p=new Properties();
		p.load(f);
		String value=p.getProperty(key);
		return value;
		
	
		
		
	}

}
