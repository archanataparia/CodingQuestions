package sortingNSearching;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter length");
		 int N = in.nextInt();
	     Integer arr[] = new Integer[N];
	        //read integer
	     System.out.println("Enter Array");
	        for(int i=0; i < N; i++)
	        {
	            arr[i] = in.nextInt();
	        }
	        insertionSort(arr);
	        in.close();

	}

	private static void insertionSort(Integer[] a) {
		// divided list in sorted and unsorted parts
		//in place sorting algo and number of comparsion in practical scenarios is  better than bubble and selection
		int i,j,temp,value,hole,len=a.length;
		for(i=1;i<len;i++)
		{	
			value=a[i];
			hole=i;
			while (hole>0 && value<a[hole-1])
			{
				a[hole]=a[hole-1];
				hole=hole-1;
			}
			a[hole]=value; 
		}
		

		System.out.println("Sorted array");
		for(Integer intarr:a)System.out.print(" "+intarr);
	}

}
