package test.java;


import static org.junit.Assert.*;

import java.util.List;
import java.util.Objects;

import org.junit.Test;

import main.java.Item;
import main.java.SortAlgos;
import main.java.SortDemo;
import main.java.SortDemoData;

public class SortDemoTest{
	public SortDemoData data = new SortDemoData();
	
	//public SortDemo sortDemo = new SortDemo();


	/**
	* testNewAccountsType checks for valid input types in the 1st parameter
	*/
	@Test
	public void testNumber() {
	   data.initializeArray("20");
	   assertTrue(data.myArray.length == 20);
	   
	   data.initializeArray("30");
	   assertTrue(data.myArray.length == 30);
	   
	   data.initializeArray("0");
	   assertTrue(data.myArray.length == 0);
	}


	/**
	 * testNewAccountsType checks for valid input types in the 1st parameter
	 */
	@Test (expected=java.lang.NegativeArraySizeException.class)
	public void negativeArraySize() {
	    data.initializeArray("-3");  
	}
	
	/**
	 * testNewAccountsType checks for valid input types in the 1st parameter
	 */
	@Test (expected=java.lang.NumberFormatException.class)
	public void NonIntegerValue() {
	    data.initializeArray("5.5");  
	}
	
	/**
	 * testNewAccountsType checks for valid input types in the 1st parameter
	 */
	@Test (expected=java.util.NoSuchElementException.class)
	public void NoSuchElem() {
	    data.initializeArray("");  
	}
	
	/**
	 * testNewAccountsType checks for valid input types in the 1st parameter
	 */
	@Test (expected=java.lang.NumberFormatException.class)
	public void NoNumber() {
	    data.initializeArray("y");  
	}
	
	/**
	 * testNewAccountsType checks for valid input types in the 1st parameter
	 */
	@Test
	public void SameNumber() {
	    data.initializeArray("5 5 64 4 4");  
	    
	    SortDemoData data2 = new SortDemoData();
	    data2.initializeArray("5 5 64");
		assertTrue(data.myArray.length == 5);
		assertTrue(data.myArray[0].key == data2.myArray[0].key );
		assertTrue(data.myArray[1].key == data2.myArray[1].key );
		assertTrue(data.myArray[2].key == data2.myArray[2].key );
	}

//	@Test
//	public void testLaunchApplet()
//	{
//		sortDemo.init();
//		sortDemo.displayHelp();
//		sortDemo.runDemo();
//	}
	
	
	// TODO: Include your test cases below
}