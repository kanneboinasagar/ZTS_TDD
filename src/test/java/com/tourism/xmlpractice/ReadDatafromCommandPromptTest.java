package com.tourism.xmlpractice;

import org.testng.annotations.Test;

public class ReadDatafromCommandPromptTest

{  
	@Test
	public void readDatafromCommandPrompt()
	{
		String  Url=System.getProperty("url");
		String Un=System.getProperty("un");
		String Pwd=System.getProperty("pwd");
		System.out.println(Url);
		System.out.println(Un);
		System.out.println(Pwd);
		
	}

}
