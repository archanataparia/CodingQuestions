package Sorting;

import java.util.Scanner;
//O(n2)
public class BubbleSort {

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
	        bubbleSort(arr);
	        in.close();


	}

	private static void bubbleSort(Integer[] a) {
		// move biggest element to left like bubble heavy element sorted first
		int i,j,temp,len=a.length;
		for(i=0;i<len;i++)
		{
			for(j=0;j<len-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("Sorted array");
		for(Integer intarr:a)System.out.print(" "+intarr);
	}

}
