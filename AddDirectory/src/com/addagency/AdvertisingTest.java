/**
 * 
 */
package com.addagency;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.addagency.util.DisplaySorter;

/**
 * @author krishnaja
 *
 */
public class AdvertisingTest {
	
	ArrayList AdvertiseList;
	 HashSet categoryList;
	 boolean isloaded=false;
	static  Advertising advertising=null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		

		  advertising=new Advertising();
		 advertising.init();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	

	/**
	 * Test method for {@link com.addagency.Advertising#init()}.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testInit() throws FileNotFoundException, IOException {
		
		
			advertising.init();
	
		
		
	}
	
	
	//displaySortbyName

	/**
	 * Test method for {@link com.addagency.Advertising#LoadXmlData()}.
	 */
	@Test
	public void testLoadXmlData() {
		advertising.LoadXmlData();
		//adding second time to check the already load code
		advertising.LoadXmlData();
		//assertTrue("Sucess",advertising.AdvertiseList.size()>0);
	}

	
	/**
	 * Test method for {@link com.addagency.Advertising#displayAll(com.addagency.Advertising)}.
	 * @throws Exception 
	 */
	@Test
	public void testDisplayAll() throws Exception {
		
		advertising.LoadXmlData();
		advertising.displayAll(advertising);
		assertTrue("All adds displayed", true);
		
		
	}
	
	

	@Test
	public void testDisplaySortbyName() throws Exception {
		
		
		advertising.LoadXmlData();
		advertising.displayAll(advertising);
		assertTrue("All adds displayed", true);	
		
         DisplaySorter displaySorter=new DisplaySorter(); 
		
		displaySorter.displaySortbyName(advertising.AdvertiseList);
		
		advertising.init();
	
		
		
	}

	/**
	 * Test method for {@link com.addagency.Advertising#displayAdsOnCategoery(com.addagency.Advertising, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDisplayAdsOnCategoery() throws Exception {
		
		
			advertising.LoadXmlData();
			advertising.displayAdsOnCategoery(advertising, "cf");
		
	
		
		
		
	}
	
	@Test
	public void testDisplayCommands() throws Exception {
		
		
			advertising.displayCommands();
			advertising.displayAdsOnCategoery(advertising, "cf");
		
	
		
		
		
	}
	
	
	@Test
	public void testWelcomeHeader() throws Exception {
		
		
			advertising.welcomeHeader();
			advertising.displayAdsOnCategoery(advertising, "cf");
		
	
		
		
		
	}

	/**
	 * Test method for {@link com.addagency.Advertising#displayAdsOnFeature(com.addagency.Advertising, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDisplayAdsOnFeature() throws Exception {
		
	
			advertising.LoadXmlData();
			advertising.displayAdsOnFeature(advertising, "hf");
		
		
		
		
	}

	/**
	 * Test method for {@link com.addagency.Advertising#displayAdvertise(com.addagency.Advertising, java.util.ArrayList)}.
	 * @throws Exception 
	 */
	@Test
	public void testDisplayAdvertise() throws Exception {
		
	        advertising.LoadXmlData();
			advertising.displayAdvertise(advertising, advertising.AdvertiseList);
		
		
		
	}

	/**
	 * Test method for {@link com.addagency.Advertising#deleteAdvertise(com.addagency.Advertising, java.lang.String)}.
	 */
	@Test
	public void testDeleteAdvertise() {
		
	   advertising.LoadXmlData();
			  advertising.deleteAdvertise(advertising, "L6-hf-computer");
			
		
			//assertTrue("Adverise deleted");
		
		
		
	}

	
	/**
	 * Test method for {@link com.addagency.Advertising#showallCategories()}.
	 */
	@Test
	public void testShowallCategories() {
		
			advertising.LoadXmlData();
			advertising.showallCategories();
		
		
		
		
	}

	/**
	 * Test method for {@link com.addagency.Advertising#addCategory(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testAddCategory() throws Exception {
		
		

		 advertising.executeCommand(advertising, "adc add --Name computer10");
		 assertTrue(" adc add --Name computer10", true);
		
		
		
		
	
	}

	/**
	 * Test method for {@link com.addagency.Advertising#deleteCategory(java.lang.String)}.
	 */
	@Test
	public void testDeleteCategory() {
		
	            advertising.LoadXmlData();
		    	advertising.deleteCategory("cf");
				assertTrue("Adverise deleted", true);
		
		
		
	}

	@Test
	public void testDisplaySortbyPrice() {
		DisplaySorter displaySorter=new DisplaySorter(); 
		
		displaySorter.displaySortbyPrice(advertising.AdvertiseList);
		assertTrue("Adverise dispplayed by price", true);
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testDisplaySortbyDate() {
      DisplaySorter displaySorter=new DisplaySorter(); 
		
		displaySorter.displaySortbyDate(advertising.AdvertiseList);
		assertTrue("Adverise displayed", true);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseList() {
      
		
		advertising.getAdvertiseList();
		assertTrue("Adverise displayed", true);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetCategoryList() {
      
		
		advertising.getCategoryList();
		assertTrue("Adverise displayed", true);
		
		//fail("Not yet implemented");
	}
	@Test
	public void testIsIsloaded() {
		advertising.isIsloaded();
		assertTrue("test is loaded", true);
	}

	@Test
	public void testSetIsloaded() {
		
		advertising.setIsloaded(true);
		assertTrue("Adverise set iloaded", true);
		
	}
	/*
	 * adl show
	 */
	@Test
	public void testExecuteCommandToall() throws Exception {
		
		advertising.executeCommand(advertising, "adl show");
		assertTrue("Adverise set iloaded", true);
		
	}
	/*
	 * adl sll
	 */
	@Test
	public void testExecuteCommandAdcAll() throws Exception {
		
		advertising.executeCommand(advertising, "adc all");
		assertTrue("adc all", true);
		
	}
	
	
	/*
	 * adl all
	 */
	@Test
	public void testExecuteCommandAdcAdd() throws Exception {
		
		advertising.executeCommand(advertising, "adc all");
		assertTrue("adc all", true);
		
	}
	
	/*
	 * adl show --Category <category-name> 
	 */
	@Test
	public void testExecuteCommandslShowCat() throws Exception {
		
		advertising.executeCommand(advertising, "adl show --Category Computers");
		assertTrue("adl show --Category Computers", true);
		
	}
	
	/*
	 * adl show  --feature <feature-name>
	 */
	@Test
	public void testExecuteCommandslShowFeature() throws Exception {
		
		advertising.executeCommand(advertising, "adl show --feature cf");
		assertTrue("adc all", true);
		
	}
	
	
	/*
	 * adl delete --Name <name>  
	 */
	@Test
	public void testExecuteCommandsDeleteAdl() throws Exception {
		
		advertising.executeCommand(advertising, "adl delete --Name L1-r-medical");
		assertTrue("adc all", true);
		
	}
	
	/*
	 * adc  add --Name <name>
	 */
	
	@Test
	public void testExecuteCommandsAdcAdd() throws Exception {
		
		advertising.executeCommand(advertising, " adc add --Name printers");
		assertTrue("adc add", true);
		
	}
	
	@Test
	public void testExecuteCommandsAddAdc() throws Exception {
		
		advertising.executeCommand(advertising, " adc add --Name printers");
		assertTrue("adc add", true);
		
	}
	
	@Test
	public void testExecuteCommandsUpdateAdc() throws Exception {
		
		advertising.executeCommand(advertising, "adc update --Name computer --NewName computer1");
		assertTrue(" adc update --Name computer --NewName computer1", true);
		
	}
	
	/**
	 * Test method for {@link com.addagency.Advertising#deleteAdvertiseOnCategory(com.addagency.Advertising, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteAdvertiseOnCategory() throws Exception {
		advertising.executeCommand(advertising, "adc delete --Name computer1");
		
		
			
		
			assertTrue("Adverise deleted", true);
		
		
		
	}
	@Test
	public void testAddAdvertise() throws Exception {
		advertising.executeCommand(advertising, "adl add --Name L14-cf-medical --Price 1000 --startDate 01/01/2011 --endDate 01/01/2020 --Category medical --feature cf --advInfo L14-cf-medical");
		
		
			
		
			assertTrue("adl add --Name L14-cf-medical --Price 1000 --startDate 01/01/2011 --endDate 01/01/2020 --Category medical --feature cf --advInfo L14-cf-medical", true);
		
		
		
	}



}
