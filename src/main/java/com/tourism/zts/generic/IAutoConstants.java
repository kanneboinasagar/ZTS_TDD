package com.tourism.zts.generic;

public interface IAutoConstants 
{
	/* In this interface we will store all the file paths
	 * In his interface every variable is public,static and final by default
	 * In interface every method is abstract by default
	 */
		
	String USERDIR=System.getProperty("user.dir");
	public static final String filepath1=USERDIR+"/Data/ProjectCredentials.properties";
	public static final String excelpath=USERDIR+"/Data/Exceldata.xlsx";
			

}
