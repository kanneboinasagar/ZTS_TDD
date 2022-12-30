package com.tourism.xmlpractice;

import org.testng.annotations.Test;

public class Demo1
{
//	@Test(priority = -1)
//	public void addTicket()
//	{
//		System.out.println("Add Ticket");
//	}
//	@Test(priority = 0)
//	public void addAnimal()
//	{
//		System.out.println("Add Animal");
//	}
//	@Test(priority = 1)
//	public void manageAnimal()
//	{
//		System.out.println("Manage Animals");

@Test(invocationCount = 2)
public void addTicket()
{
	System.out.println("Add Ticket");
}

@Test(dependsOnMethods = "addTicket")
public void addAnimal()
{
	System.out.println("Add Animal");
}
@Test(enabled = true)
public void manageAnimal()
{
	System.out.println("Manage Animals");
}	




}


