package com.addagency.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import com.addagency.Advertising;

public class DisplaySorter{
	
	  
	  

public static ArrayList   displaySortbyPrice(ArrayList advertiseLIst)
{
	
	   ArrayList priceList=new ArrayList();
	   ArrayList tempaddsList=advertiseLIst;
	   
	   ArrayList sortedAddsList=new ArrayList();
	   ArrayList unsortedAddsList=advertiseLIst;
	   
	
	for (Iterator iterator = advertiseLIst.iterator(); iterator.hasNext();) {
		Advertise object = (Advertise) iterator.next();
		
		priceList.add(new Double(object.getPrice()));
			
	}
	
	
	Collections.sort(priceList);
	
	//System.out.println("after sort------------------");
	

	
	
	for (Iterator iterator = priceList.iterator(); iterator.hasNext();) {
		Double object = (Double) iterator.next();
		
		for (Iterator iterator2 = unsortedAddsList.iterator(); iterator2
				.hasNext();) {
			Advertise object1 = (Advertise) iterator2.next();
			double dobvalue=object1.getPrice();
			
			if(object == dobvalue)
			{
				
				sortedAddsList.add(object1);
				unsortedAddsList.remove(object1);
				break;
				
			}
			
			
		}
		
		
		
		
	}
	

	
	return sortedAddsList;
	
}


public static ArrayList   displaySortbyDate(ArrayList advertiseLIst)
{
	
	   ArrayList datesList=new ArrayList();
	   ArrayList tempaddsList=advertiseLIst;
	   
	   ArrayList sortedAddsList=new ArrayList();
	   ArrayList unsortedAddsList=advertiseLIst;
	   
	
	for (Iterator iterator = advertiseLIst.iterator(); iterator.hasNext();) {
		Advertise object = (Advertise) iterator.next();
		
		datesList.add(new Date(object.getStartDate()));
			
	}
	
	//System.out.println("dates before sort");
	
	/*for (Iterator iterator = datesList.iterator(); iterator.hasNext();) {
		Date object = (Date) iterator.next();
		System.out.println(object.toGMTString());
		
	}*/
	
	Collections.sort(datesList);
	
	
	
	for (Iterator iterator = datesList.iterator(); iterator.hasNext();) {
		Date object = (Date) iterator.next();
		
		for (Iterator iterator2 = unsortedAddsList.iterator(); iterator2
				.hasNext();) {
			Advertise object1 = (Advertise) iterator2.next();
			String dobvalue=new Date(object1.getStartDate()).toGMTString();
			
			if(object.toGMTString().equalsIgnoreCase(dobvalue))
			{
				
				sortedAddsList.add(object1);
				unsortedAddsList.remove(object1);
				break;
				
			}
			
			
		}
		
		
		
		
	}
	
	
	
	return sortedAddsList;
	
}

public static ArrayList   displaySortbyName(ArrayList advertiseLIst)
{
	
	   ArrayList nameList=new ArrayList();
	   ArrayList tempaddsList=advertiseLIst;
	   
	   ArrayList sortedAddsList=new ArrayList();
	   ArrayList unsortedAddsList=advertiseLIst;
	   
	
	for (Iterator iterator = advertiseLIst.iterator(); iterator.hasNext();) {
		Advertise object = (Advertise) iterator.next();
		
		nameList.add(object.getAddName());
			
	}
	
	
	Collections.sort(nameList);
	
	
	
	
	for (Iterator iterator = nameList.iterator(); iterator.hasNext();) {
		String object = (String) iterator.next();
		
		for (Iterator iterator2 = unsortedAddsList.iterator(); iterator2
				.hasNext();) {
			Advertise object1 = (Advertise) iterator2.next();
			String dobvalue=object1.getAddName();
			
			if(object.equalsIgnoreCase(dobvalue))
			{
				
				sortedAddsList.add(object1);
				unsortedAddsList.remove(object1);
				break;
				
			}
			
			
		}
		
	}
	
	
	return sortedAddsList;
	
}






}






















