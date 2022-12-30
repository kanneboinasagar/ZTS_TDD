package com.tourism.xmlpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2_DataProvider
{
	@Test(dataProvider = "provideData")
	public void add(String animalname,double price)
	{
		System.out.println(animalname+"-->"+price);
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object objArr [][]=new Object[4][2];
		
		objArr[0][0]="White Tiger";
		objArr[0][1]=5000;
		
		objArr[1][0]="Deer";
		objArr[1][1]=1500;
		
		objArr[2][0]="Cheetah";
		objArr[2][1]=2500;
		
		objArr[3][0]="Lion";
		objArr[3][1]=6500;
		
		return objArr;
		
	}

}
