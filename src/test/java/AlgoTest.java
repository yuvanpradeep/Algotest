package test.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import jdk.nashorn.internal.ir.annotations.Ignore;
import main.java.Item;
import main.java.RandomNumber;
import main.java.SortAlgos;

public class AlgoTest {

    SortAlgos algobj = new SortAlgos();

	private int Inputsize = 1000;
	
	// Generating input values using random generator
	private Item[] gettingInputItems(int Inputsize) {
		Item[] itemvals = null;
		if (Inputsize > 0) {
			itemvals =  new Item[Inputsize];
			RandomNumber random = new RandomNumber();
			for (int i = 0; i< Inputsize; i++) {
				itemvals[i] = new Item(random.nextIntRand(0, Inputsize));
			}
		}
		return itemvals;
	}
	
	// node coverage case 5 scenario
	private Item[] valuesforcoverage5(){
		Item[] items = new Item[10];
		int nums[] = new int[10];
		nums = new int[]{19,18,9,8,7,5,3,2,1,0};
		
		for(int i=0;i<nums.length;i++)
		{
			items[i] = new Item(nums[i]);
		}
		return items;
	}
	

	// node coverage case 4 scenario
	private Item[] valuesforcoverage4(){
		Item[] items = new Item[10];
		int nums[] = new int[10];
		nums = new int[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,0};
		
		for(int i=0;i<nums.length;i++)
		{
			items[i] = new Item(nums[i]);
		}
		return items;
	}
	
	private Item[] valuesforcoverage9(){
		Item[] items = new Item[10];
		int nums[] = new int[10];
		nums = new int[]{1,1,1,1,1,1,1,1,1,1};
		
		for(int i=0;i<nums.length;i++)
		{
			items[i] = new Item(nums[i]);
		}
		return items;
	}
	
	
	// node coverage case 2 scenario
	private Item[] valuesforcoverage2(){
		Item[] items = new Item[1];
		int nums[] = new int[1];
		nums = new int[]{1};
		
		for(int i=0;i<nums.length;i++)
		{
			items[i] = new Item(nums[i]);
		}
		return items;
	}
	
	@Test
	public void compareBubblesortwithallOtherSortingalgoUsingRandom() {
		
		Item[] items = gettingInputItems(Inputsize);
		Item[] items1 = new Item[items.length];
		Item[] items2 = new Item[items.length];
		Item[] items3 = new Item[items.length];
		Item[] items4 = new Item[items.length];
		Item[] items5 = new Item[items.length];
	
		System.arraycopy(items, 0, items1, 0, items.length);
		System.arraycopy(items, 0, items2, 0, items.length);
		System.arraycopy(items, 0, items3, 0, items.length);
		System.arraycopy(items, 0, items4, 0, items.length);
		System.arraycopy(items, 0, items5, 0, items.length);
		
		SortAlgos.bubbleSort(items);
		SortAlgos.quickSort(items1);
		for (int i =0;i<Inputsize;i++) {
			assert(items[i].key == items1[i].key);
		}
		SortAlgos.selectionSort(items2);
		for (int i =0;i<Inputsize;i++) {
			assert(items[i].key == items2[i].key);
		}
		SortAlgos.insertionSort(items3);
		for (int i =0;i<Inputsize;i++) {
			assert(items[i].key == items3[i].key);
		}
		SortAlgos.heapSort(items4);
		for (int i =0;i<Inputsize;i++) {
			assert(items[i].key == items4[i].key);
		}
		SortAlgos.mergeSort(items5);
		for (int i =0;i<Inputsize;i++) {
			assert(items[i].key == items5[i].key);
		}
	}
	
	// When the input is null it comes under node coverage 1 scenario
	@Test (expected = NullPointerException.class) 
	public void BubbleSortCoverageWhenInputIsNull() {
		Item arr8[] = new Item[10];
		Item arr9[] = new Item[10];
		int num[]=new int[10];
		num = new int[] {};
		for(int i =0;i<num.length;i++)
		{
			arr8[i]=new Item(num[i]);
			arr9[i] = new Item(num[i]);
		}
			SortAlgos.bubbleSort(arr8);
			for(int j =0;j<num.length;j++)
			{
				assert(arr8[j].key== arr9[j].key);
			}
		}
	
	@Test
	public void compareBubbleSortResultsWithSelectionSortResultsForSameValues() {
		Item[] items = valuesforcoverage9();
		Item[] items1 = new Item[items.length];
		System.arraycopy(items, 0, items1, 0, items.length);
		SortAlgos.bubbleSort(items);
		SortAlgos.selectionSort(items1);
		for (int i =0;i<items.length;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	@Test
	public void compareBubbleSortResultsWithSelectionSortResultsForDescendingValues() {
		Item[] items = valuesforcoverage5();
		Item[] items1 = new Item[items.length];
		System.arraycopy(items, 0, items1, 0, items.length);
		SortAlgos.bubbleSort(items);
		SortAlgos.selectionSort(items1);
		for (int i =0;i<items.length;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	@Test
	public void compareBubbleSortResultsWithInsertionSortResultsForAscendingValues() {
		Item[] items = valuesforcoverage4();
		Item[] items1 = new Item[items.length];
		System.arraycopy(items, 0, items1, 0, items.length);
		SortAlgos.bubbleSort(items);
		SortAlgos.insertionSort(items1);
		
		for (int i =0;i<items.length;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	@Test
	public void compareBubbleSortResultsWithHeapSortResultsForOneValue() {
		Item[] items = valuesforcoverage2();
		Item[] items1 = new Item[items.length];
		System.arraycopy(items, 0, items1, 0, items.length);
		SortAlgos.bubbleSort(items);
		SortAlgos.heapSort(items1);
		for (int i =0;i<items.length;i++) {
			assert(items[i].key == items1[i].key);
		}
	}
	
	// when the input is null handling exception
	@Test (expected = NullPointerException.class) 
	public void bubbleSortThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.bubbleSort(gettingInputItems(0));
	}
	@Test (expected = NullPointerException.class) 
	public void insertionSortThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.insertionSort(gettingInputItems(0));
	}
	@Test (expected = NullPointerException.class) 
	public void mergenSortThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.mergeSort(gettingInputItems(0));
	}
	
	@Test (expected = NullPointerException.class) 
	public void selectionSortThrowsNullPointerExceptionIfInputIsNull() {
		SortAlgos.selectionSort(gettingInputItems(0));
	}
}