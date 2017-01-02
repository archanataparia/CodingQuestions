package sortingNSearching;

import java.util.Scanner;
//O(n2)
public class SelectionSort {
	
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
	        selectionSort(arr);
	        in.close();


	}

	private static void selectionSort(Integer[] a) {
		//left unsorted, right sorted
		//select min element and move it to right or first
		int min,temp;
		int i,j,len=a.length;
		for(j=0;j<len;j++)
		{
			//set minimum index at first element
			min=j;
			for(i=j+1;i<len;i++)
			{
				if(a[i]<a[min])
					min=i;
			}
			//swap values
			temp=a[min];
			a[min]=a[j];
			a[j]=temp;
			
		}
		System.out.println("Sorted array");
		for(Integer intarr:a)System.out.print(" "+intarr);
	}

}
