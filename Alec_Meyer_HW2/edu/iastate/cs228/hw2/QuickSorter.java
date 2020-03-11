package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{
	
	// Other private instance variables if you need ... 
		
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *   
	 * @param pts   input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
		super(pts);
		algorithm = "quick sort";
	}
		

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{
		quickSortRec(0, points.length - 1);
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
		if(first < last)
		{
			int partition = partition(first, last);
			
			//below the pivot
			quickSortRec(first, partition - 1); 
			
			//above the pivot
			quickSortRec(partition + 1, last);
		}
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * implemented from 227 textbook chapter 14.5
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last)
	{
		Point pivot = points[last];
		
		int i = (first - 1);
		
		for(int j = first; j < last; j++)
		{
			if(pointComparator.compare(points[j], pivot) < 0)
				swap(++i, j);
		}
		swap(i + 1, last);
		return i + 1; 
	}	
		
}