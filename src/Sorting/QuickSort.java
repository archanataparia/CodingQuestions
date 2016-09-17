package Sorting;

import java.util.Scanner;

public class QuickSort {

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
	        quickSort(arr, 0,arr.length-1);
	        in.close();


	}

	private static void quickSort(Integer[] a, int start, int end) {
		// partition the list such as choose pivot and element are lesser than pivot are to the left or greater to the right
		if(start>=end) return;//base condition If only one element in partition or invalid segment
		int  pIndex;
		pIndex=partitionArray(a,start,end);
		quickSort(a,start,pIndex-1);
		quickSort(a,pIndex+1,end);
		System.out.println("Sorted array");
		for(Integer intarr:a)System.out.print(" "+intarr);
	}

	private static int partitionArray(Integer[] a, int start, int end) {
		// make last index pivot element and set partitionindex to the start
		Integer pivot=a[end];
		int temp,pIndex = start;
		for (int i=0;i<end;i++)
		{
			if(a[i]<=pivot)
			{
				temp=a[i];
				a[i]=a[pIndex];
				a[pIndex]=temp;
				pIndex++;
			}
		}
		//swaping the last element in the partition with the pivot
		temp=a[end];
		a[end]=a[pIndex];
		a[pIndex]=temp;
		
		return pIndex;
	}
	
}
