package com.addagency;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;










import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

import com.addagency.util.AddList;
import com.addagency.util.Advertise;
import com.addagency.util.DisplaySorter;


public class Advertising {
	
	
	 static ArrayList AdvertiseList;
	 static HashSet categoryList;
	 boolean isloaded=false;
	 Properties properties=new Properties();
	
	
	
	
	public ArrayList getAdvertiseList() {
		return AdvertiseList;
	}


	public void setAdvertiseList(ArrayList advertiseList) {
		AdvertiseList = advertiseList;
	}


	public HashSet getCategoryList() {
		return categoryList;
	}


	public void setCategoryList(HashSet categoryList) {
		this.categoryList = categoryList;
	}


	public boolean isIsloaded() {
		return isloaded;
	}


	public void setIsloaded(boolean isloaded) {
		this.isloaded = isloaded;
	}




	


	public Advertising init() throws FileNotFoundException, IOException
	{
		
		Advertising advertising=new Advertising();
		Properties properties=advertising.loadProperties("../conf.properties");
		advertising.loadProperties(properties.getProperty("xmlFileLocation"));
		AdvertiseList=new ArrayList();
		advertising.setAdvertiseList(AdvertiseList);
		categoryList=new HashSet();
		advertising.setCategoryList(categoryList);
		
		System.out.println("---init method called--");
		return advertising;
		
		
		
	}
	
	
	public void welcomeHeader()
	{
		
		
		//System.out.println(System.getProperty("java.classpath"));
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("+                                                                                                                                                               +");
		 System.out.println("+                                                                                                                                                               +");
		 System.out.println("+                                                                                                                                                               +");
		 System.out.println("+                         Welcome to Addvertising Lists                                                                                                         +");
		 System.out.println("+                                                                                                                                                               +");
		 System.out.println("+                                                                                                                                                               +");
		 System.out.println("+                                                                                                                                                               +");
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	
	public void displayCommands()
	{
		
		
		 System.out.println("======================================================================================================================================================================================*");
		 System.out.println("*                Valid commands                                                                                                                                                       *");
		 System.out.println("*                1 Load                                                                                                                                                               *");
		 System.out.println("                 2 adl show                                                                                                                                                           *");
	     System.out.println("                 3 adl show --Category <category-name>                                                                                                                                *");
	     System.out.println("                 4 adl show  --feature <feature-name>                                                                                                                                 *");
	     System.out.println("                 5 adl add --Name <name> --price <price>  --startDate <start date> --endDate <end date> --Category <category> --feature <feature> --advertiserInfo <advertiserInfo>   *");
	     System.out.println("                 6 adc show                                                                                                                                                           *");
	     System.out.println("                 7 adl delete --Name <name>                                                                                                                                           *");
	     System.out.println("                 8 adc  add --Name <name>                                                                                                                                             *");
	     System.out.println("                 9 adc delete --Name <category name>                                                                                                                                  *");
	     System.out.println("                 10 adc update --Name <category Namew> --NewName <Category New Name>                                                                                                                     *");
	     
	     System.out.println("*===============================================================================================================================================================+++++++++++++++++++++++*");
		 
		
		 
		
		 
	}
	
	
	public void LoadXmlData()
	{
		PojoXml pojoXml=PojoXmlFactory.createPojoXml();
		
		pojoXml.addCollectionClass("Advertise", Advertise.class);
        AddList advList=(AddList)pojoXml.getPojo("../xmldatafile.xml", AddList.class);
		//System.out.println("size is -->"+advList.getAddList1().size());
		
		ArrayList arrayList=(ArrayList) advList.getAddList1();
		
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			Advertise object = (Advertise) iterator.next();
			AdvertiseList.add(object);
			
			
			categoryList.add(object.getCatagory());
			
		}
		
		System.out.println("<--------------------The data loaded successfully---------------------->");
		//System.out.println("adds size-->"+AdvertiseList.size()+"          "+"categoryList size--->"+categoryList.size());
		
	}
	
	

	public void executeCommand(Advertising advertising, String command) throws Exception
	{
		
		

			String data[] = command.split(" ");

			System.out.println(data.length);

			if (data.length == 2) {
				
				foradlAdc2(data, advertising);
				
			
			}

			else if (data.length == 4) {
				foradlAdc4(data, advertising);
				
				
				
			}
			/*1)validate category , if exists ,then validate the name , if the name not exists then create.]
			 * 
			 */
			else if (data.length == 16)
			{
				
				foradlAdc16(data, advertising);
				
			}
			else if((data.length==1) && (data[0].equalsIgnoreCase("load")))
			{
				//Advertising advertising1=new Advertising();
				
				//advertising.displayCommands();
				//advertising.execute();
			    if(isloaded)
			    {
			    	System.out.println("The Xml data already loaded");
			    	System.out.println();
			    }
			    else
			    {
			    	advertising.LoadXmlData();
			    	isloaded=true;
			    }
				
			}
			else if((data.length==6) && (data[0].equalsIgnoreCase("adc"))
					
					&& data[1].equalsIgnoreCase("update")
					&& data[2].equalsIgnoreCase("--Name")
					&& (!data[3].trim().equalsIgnoreCase(""))
					&& data[4].equalsIgnoreCase("--NewName")
					&& (!data[5].trim().equalsIgnoreCase("")))
			{
				advertising.modifyCategory(data[3], data[5]);
			}
			
			else
			{
				
				//wrong show commands
				advertising.displayCommands();
			}

			// System.out.println(command);
		}

	
	public static void foradlAdc2(String[] data, Advertising advertising1) throws Exception
	{
		

		if (data[0].equalsIgnoreCase("adl")
				&& data[1].equalsIgnoreCase("show")) {

			// logic to show all the listings
			//System.out.println("adl ---show");
			
			advertising1.displayAll(advertising1);
			
			
		}

		else if (data[0].equalsIgnoreCase("adc")
				&& data[1].equalsIgnoreCase("show")) {
			//System.out.println("adc ---show--show all the cataegories");
			
			advertising1.showallCategories();
		}

		else {
			advertising1.displayCommands();

			//System.out.println("----wrong command---------------------");
		}

	
		
	}
	
	public static void foradlAdc4(String[] data, Advertising advertising1) throws Exception
	{
		if (data[0].equalsIgnoreCase("adl")
				&& data[1].equalsIgnoreCase("show")
				&& data[2].equalsIgnoreCase("--Category")
				&& (!data[3].trim().equalsIgnoreCase(""))) {
			
			

			System.out.println("category---->" + data[3].trim());
			System.out.println("display list specific to the category");
			
			advertising1.displayAdsOnCategoery(advertising1, data[3].trim());
			

		} else if (data[0].equalsIgnoreCase("adl")
				&& data[1].equalsIgnoreCase("show")
				&& data[2].equalsIgnoreCase("--feature")
				&& (!data[3].trim().equalsIgnoreCase(""))) {

			//System.out.println("feature---->" + data[3].trim());
			//System.out.println("display list specific to the feature");
			advertising1.displayAdsOnFeature(advertising1,data[3].trim());

		} else if (data[0].equalsIgnoreCase("adl")
				&& data[1].equalsIgnoreCase("delete")
				&& data[2].equalsIgnoreCase("--Name")
				&& (!data[3].trim().equalsIgnoreCase(""))) {
			
			
			advertising1.deleteAdvertise(advertising1, data[3].trim());

			//System.out.println("delete---->" + data[3].trim());
			//System.out.println("delete advts from list ");

		}

		else if (data[0].equalsIgnoreCase("adc")
				&& data[1].equalsIgnoreCase("add")
				&& data[2].equalsIgnoreCase("--Name")
				&& (!data[3].trim().equalsIgnoreCase(""))) {
			
			
			advertising1.addCategory(data[3].trim());
			

			//System.out.println("add category from the given list");

		} else if (data[0].equalsIgnoreCase("adc")
				&& data[1].equalsIgnoreCase("delete")
				&& data[2].equalsIgnoreCase("--Name")
				&& (!data[3].trim().equalsIgnoreCase(""))) {

			//System.out.println("delete a category from the list");
			
			advertising1.deleteAdvertiseOnCategory(advertising1, data[3].trim());
			advertising1.deleteCategory(data[3].trim());

		} 
		
		
		else
		{
			
			//wrong show commands
			advertising1.displayCommands();
		}


	
		
	}
	
	public static void foradlAdc16(String[] data, Advertising advertising1) throws Exception
	{
		//adding a list
		
		if(data[0].equalsIgnoreCase("adl")
				&& data[1].equalsIgnoreCase("add")
				&& data[2].equalsIgnoreCase("--Name")
				&& (!data[3].trim().equalsIgnoreCase(""))
				&& data[4].equalsIgnoreCase("--Price")
				&& (!data[5].trim().equalsIgnoreCase(""))
						&& data[6].equalsIgnoreCase("--startDate")
						&& (!data[7].trim().equalsIgnoreCase(""))
								&& data[8].equalsIgnoreCase("--endDate")
								&& (!data[9].trim().equalsIgnoreCase(""))
										&& data[10].equalsIgnoreCase("--Category")
										&& (!data[11].trim().equalsIgnoreCase(""))
										&& data[12].equalsIgnoreCase("--feature")
												&& (!data[13].trim().equalsIgnoreCase("")
												&& data[14].equalsIgnoreCase("--advInfo")
												&& (!data[15].trim().equalsIgnoreCase(""))
												))
		{
			
			
			String strCategory=data[11].trim();
			boolean isCategoryExists=false;
			String strListName=data[3].trim();
			boolean isListNameExists=false;
			
			for (Iterator iterator = categoryList.iterator(); iterator
					.hasNext();) {
				String strName = (String) iterator.next();
				if(strName.equalsIgnoreCase(strCategory))
				{
					isCategoryExists=true;
				}
				
			}
			
			if(isCategoryExists)
			{
				
				//validate the , Is the name already exists?
				
				for (Iterator iterator = AdvertiseList.iterator(); iterator
						.hasNext();) {
					Advertise object = (Advertise) iterator.next();
					if(object.getAddName().equalsIgnoreCase(strListName))
					{
						isListNameExists=true;
					}
					
					
				}
				
				if(isListNameExists)
				{
					System.out.println("The name already exists, Please choose another name to create");
				}
				else
				{
					//create a record
					
					Advertise advertise=new Advertise();
					advertise.setAddName(data[3].trim());
					advertise.setPrice(new Integer(data[5].trim()).intValue());
					advertise.setStartDate(data[7].trim());
					advertise.setEndDate(data[9].trim());
					advertise.setCatagory(data[11].trim());
					advertise.setFeature(data[13].trim());
					advertise.setAdvertiserInfo(data[15].trim());
					
					AdvertiseList.add(advertise);
					
					
					
				}
				
				
				
			}
			
			else
			{
				System.out.println("Category does not exists");
			}
			
			
			
			
			
		}
		else
		{
			advertising1.displayCommands();
		}
		
		
		
		
		
	}
	/*
	 * 
	 * $ adl show    # this will show the "home page"

      List the categories in alphabetic order and indicate for each of them how many listing are in the category>
       List the home-page featured listings.

      So, the specific output for the above command will be:

    Computer (2), Lawyers (2), Medical (3)
    Featured listings:

        L6-hf-computer 
        L7-hf-lawyers
	 */
	
	
	
	
	
	public void displayAll(Advertising advertising) throws Exception//implementation : adl show
	{
		
		ArrayList AdvertiseListTemp=AdvertiseList;
		HashSet categoryListTmp=categoryList;
		
		ArrayList displayList=new ArrayList();
		
		Hashtable categorySummary=new Hashtable<Object, Object>();
		
		int categoryCount=0;
		
		
		for (Iterator iterator = categoryListTmp.iterator(); iterator.hasNext();) {
			String strCategory = (String) iterator.next();
			
			for (Iterator AdvertiseListTemp1 = AdvertiseListTemp.iterator(); AdvertiseListTemp1
					.hasNext();) {
				Advertise object = (Advertise) AdvertiseListTemp1.next();
				
				if(object.getCatagory().equalsIgnoreCase(strCategory))
				{
					categoryCount++;
				}
				
			}
			categorySummary.put(strCategory, categoryCount);
			
			System.out.println(strCategory+"("+categoryCount+")");
			categoryCount=0;
		
		  
		  
		
		}
		
		
		//creating list to display home page featured
		for (Iterator AdvertiseListTemp1 = AdvertiseListTemp.iterator(); AdvertiseListTemp1.hasNext();) {
			Advertise object = (Advertise) AdvertiseListTemp1.next();
			
			
			if(object.getFeature().equalsIgnoreCase("hf"))
			{
				displayList.add(object);
			}
		
		}
		advertising.displayAdvertise(advertising, displayList);
		
		
		
	}
	
	
	
	
	
	
	public void displayAdsOnCategoery(Advertising advertising, String category) throws Exception//implementation : adl show
	{

		
		ArrayList AdvertiseListTemp=AdvertiseList;
		
		ArrayList AdvertiseListAllCatTemp=AdvertiseList;
	
		
		ArrayList displayList=new ArrayList();
		ArrayList displayList1=new ArrayList();
		
		

		
		
		
		
		//creating list to display home page featured
		for (Iterator AdvertiseListTemp1 = AdvertiseListTemp.iterator(); AdvertiseListTemp1.hasNext();) {
			Advertise object = (Advertise) AdvertiseListTemp1.next();
			
			
			if(object.getFeature().equalsIgnoreCase("cf") && object.getCatagory().equalsIgnoreCase(category) )
			{
				displayList.add(object);
			}
		
		}
		advertising.displayAdvertise(advertising, displayList);
		
		//creating list to display home page featured
				for (Iterator AdvertiseListTemp1 = AdvertiseListTemp.iterator(); AdvertiseListTemp1.hasNext();) {
					Advertise object = (Advertise) AdvertiseListTemp1.next();
					
					
					if( object.getCatagory().equalsIgnoreCase(category) )
					{
						displayList1.add(object);
					}
				
				}
		
		advertising.displayAdvertise(advertising, displayList1);
		
		
	}
	
	public void displayAdsOnFeature(Advertising advertising, String feature) throws Exception//implementation : adl show
	{

		
		ArrayList AdvertiseListTemp=AdvertiseList;
		
		ArrayList AdvertiseListAllCatTemp=AdvertiseList;
	
		
		ArrayList displayList=new ArrayList();
		ArrayList displayList1=new ArrayList();
		
		
		//creating list to display home page featured
		for (Iterator AdvertiseListTemp1 = AdvertiseListTemp.iterator(); AdvertiseListTemp1.hasNext();) {
			Advertise object = (Advertise) AdvertiseListTemp1.next();
			
			
			if(object.getFeature().equalsIgnoreCase(feature) )
			{
				displayList.add(object);
			}
		
		}
		advertising.displayAdvertise(advertising, displayList);
		
				
	
		
		
	}
	public void displayAdvertise(Advertising  advertising, ArrayList addsList) throws Exception
    {

		
		
			DisplaySorter displaySorter=new DisplaySorter();
			Properties properties=advertising.loadProperties("../conf.properties");
			
			String diplayType=properties.getProperty("displayType");
			
			
			
			if(diplayType.equalsIgnoreCase("price"))
			{
				addsList=displaySorter.displaySortbyPrice(addsList);
				
			}
			else if(diplayType.equalsIgnoreCase("name"))
			{
				
				addsList=displaySorter.displaySortbyName(addsList);
			}
			else if(diplayType.equalsIgnoreCase("date"))
			{
				
				addsList=displaySorter.displaySortbyDate(addsList);
			}
		
		
		
		for (int i = 0; i < 180; i++) {
			System.out.print("+");
		}
		System.out.println();

		System.out.print("Name");
		for (int i = 0; i < 26; i++) {
			System.out.print(" ");
		}
		
		System.out.print("Category");
		for (int i = 0; i < 26; i++) {
			System.out.print(" ");
		}


		System.out.print("startDate");
		for (int i = 0; i < 21; i++) {
			System.out.print(" ");
		}

		System.out.print("endDate");
		for (int i = 0; i < 23; i++) {
			System.out.print(" ");
		}
		System.out.print(" Price");
		for (int i = 0; i < 24; i++) {
			System.out.print(" ");
		}

		System.out.print(" Info");
		for (int i = 0; i < 54; i++) {
			System.out.print(" ");
		}

		System.out.println();
		for (int i = 0; i < 180; i++) {
			System.out.print("+");
		}
		System.out.println(" ");

		for (Iterator iterator = addsList.iterator(); iterator.hasNext();) {
			Advertise admin2 = (Advertise) iterator.next();

			String idstr = admin2.getAddName();
			System.out.print(idstr);
			for (int i = 0; i < (30 - idstr.length()); i++) {
				System.out.print(" ");
			}
			
			String catgory = admin2.getCatagory();
			System.out.print(catgory);
			for (int i = 0; i < (30 - catgory.length()); i++) {
				System.out.print(" ");
			}

			String namestr = admin2.getStartDate();
			System.out.print(namestr);
			for (int i = 0; i < (30 - namestr.length()); i++) {
				System.out.print(" ");
			}

			String emailstr = admin2.getEndDate();
			System.out.print(emailstr);
			for (int i = 0; i < (30 - emailstr.length()); i++) {
				System.out.print(" ");
			}

			double price1 = admin2.getPrice();

			String strPrice1 = new String(new Double(price1).toString());
			System.out.print(price1);
			for (int i = 0; i < (30 - strPrice1.length()); i++) {
				System.out.print(" ");
			}

			String info = admin2.getAdvertiserInfo();
			System.out.print(info);
			for (int i = 0; i < (60 - info.length()); i++) {
				System.out.print(" ");
			}

			System.out.println();
		}

		for (int i = 0; i < 180; i++) {
			System.out.print("+");
		}
		
		System.out.println();
		
		
		
		

	}
	
	
	
	public void deleteAdvertise(Advertising advertise, String Name)
	{
		boolean isdeleted=false;
		
        
		
		ArrayList tempAddList=new ArrayList();
		tempAddList.addAll(AdvertiseList);
		
		
		for (Iterator iterator = AdvertiseList.iterator(); iterator.hasNext();) {
			Advertise object = (Advertise) iterator.next();
			
			if(object.getAddName().equalsIgnoreCase(Name))
			{
				//AdvertiseList.remove(object);
				tempAddList.remove(object);
				isdeleted=true;
			}
			
					
		}
		if(isdeleted)
		{ 
			
			AdvertiseList.clear();
			AdvertiseList.addAll(tempAddList);
			System.out.println("successfully deleted "+Name);
		}
		else
		{
			System.out.println("There is no advertise exists with the name :"+Name);
		}
			
		
		
		
	}
	

	public void deleteAdvertiseOnCategory(Advertising advertise, String category)
	{
		boolean isdeleted=false;
		
		ArrayList tempAddList=new ArrayList();
		tempAddList.addAll(AdvertiseList);
		
		for (Iterator iterator = AdvertiseList.iterator(); iterator.hasNext();) {
			Advertise object = (Advertise) iterator.next();
			
			if(object.getCatagory().equals(category))
			{
			//	AdvertiseList.remove(object);
				tempAddList.remove(object);
				isdeleted=true;
				//System.out.println("Advertise/advertises  on category ");
			}
			
					
		}
		if(isdeleted)
		{
			AdvertiseList.clear();
			AdvertiseList.addAll(tempAddList);
			
			System.out.println("successfully deleted "+category);
		}
		else
		{
			System.out.println("There is no advertise exists on the category name :"+category);
		}
			
		
		
		
	}
	
	
	public void showallCategories()
	{
		HashSet categoryList1=categoryList;
		
		for (Iterator iterator = categoryList1.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();
			System.out.println(object);
			
		}
		
	}
	
	public void addCategory(String name)
	{
		HashSet categoryList1=categoryList;
		
		boolean isContains=false;
		
		for (Iterator iterator = categoryList1.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();
			if(name.equalsIgnoreCase(object))
			{
				isContains=true;
				
				
			}
			
		}
		
		if(isContains)
		{
			System.out.println("Already category "+ name +"Exists");
		}
		else
		{
			categoryList.add(name);
			
			System.out.println("Successfully Category "+name+ "added");
		}
		
		
		
		
	}
	
	
	public void modifyCategory(String name, String newName)
	{
		HashSet categoryList1=categoryList;
		
		boolean isContains=false;
		
		for (Iterator iterator = categoryList1.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();
			if(name.equalsIgnoreCase(object))
			{
				isContains=true;
				
				
			}
			
		}
		
		if(isContains)
		{
			//System.out.println("Already category "+ name +"Exists");
		//	categoryList.add(name);
			int i=0;
			boolean ismodified=false;
			HashSet categoryList2=new HashSet();
			
			
			for (Iterator iterator = categoryList.iterator(); iterator
					.hasNext();) {
				String  catname = (String ) iterator.next();
				
				if(catname.equalsIgnoreCase(name))
				{
				categoryList2.add(newName);
				ismodified=true;
				}
				else
				{
					categoryList2.add(catname);
				}
			
					i++;
				
			}
			
			categoryList=null;
			categoryList=new HashSet();
			categoryList.addAll(categoryList2);
			
			if(ismodified)
			{
				ArrayList tempAdvertiseList=new ArrayList();				
				for (Iterator iterator = AdvertiseList.iterator(); iterator
						.hasNext();) {
					Advertise object = (Advertise) iterator.next();
					
					
					if(object.getCatagory().equalsIgnoreCase(name))
					{
						
						object.setCatagory(newName);
						
					}
					
					
					tempAdvertiseList.add(object);
					
					
				}
				
				
				AdvertiseList=null;
				AdvertiseList=new ArrayList();
				AdvertiseList.addAll(tempAdvertiseList);
				
				
			}
			
		}
		else
		{
			
			
			System.out.println(" Category "+name+ "does not exists");
		}
		
		
		
		
	}
	
	public void deleteCategory(String name)
	{

		HashSet categoryList1=categoryList;
		
		boolean isContains=false;
		
		for (Iterator iterator = categoryList.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();
			if(name.equals(object))
			{
				isContains=true;
				
				
			}
			
		}
		
		if(isContains)
		{
			categoryList.remove(name);
			System.out.println("The category Successfully removed");
			
		}
		else
		{
			//categoryList.add(name);
			
			System.out.println("The category does not exists");
		}
		
		
		
		
	
		
		
	}
	
	public Properties loadProperties(String path) throws FileNotFoundException,IOException
	{
	
			//FileReader fileReader  =new FileReader(path);
			FileInputStream inStream=new FileInputStream(path);
			Properties properties=new Properties();
			properties.load(inStream);
     		return properties;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Advertising advertising=new Advertising();
		

		advertising.init();
		advertising.welcomeHeader();
		advertising.displayCommands();
		
		String loop="";
        BufferedReader br=null;
		System.out.println("execute---------------");
			 
		br = new BufferedReader(new InputStreamReader(System.in));
		while(null!=loop)
      {

			String command = br.readLine();
		
		   advertising.executeCommand(advertising , command);
      }
		
		
		
		
	}

}
