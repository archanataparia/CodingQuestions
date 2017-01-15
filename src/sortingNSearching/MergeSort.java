package sortingNSearching;

import java.util.Scanner;
//O(nlogn)
public class MergeSort {

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
	        mergeSort(arr);
	        in.close();

	}

	private static void mergeSort(Integer[] a) {
		// divide the array in left and right and then call merge function
		int len=a.length,mid=len/2;
		int lLen=mid,rLen=len-mid;
		if(len<2) return;//base condition or exit condition for recursion
			
		Integer[] left = new Integer[lLen];
		Integer[] right = new Integer[rLen];
				
		for(int i=0;i<mid;i++)
		{
			left[i]=a[i];
			//System.out.println("left "+ left[i]+ " i "+ i);
		}
		for(int i=mid;i<len;i++)
		{
			right[i-mid]=a[i];
			//System.out.println("right "+ right[i-mid]+ "i "+ i);
		}
		mergeSort(left);
		mergeSort(right);
		Integer output[]=merge(left,right,a);
		
		System.out.println("Sorted array");
		for(Integer intarr:output)System.out.print(" "+intarr);
		
	}

	

	private static Integer[] merge(Integer[] left, Integer[] right, Integer[] a) {
		
		int leftLen = left.length, rightLen = right.length;
		int i=0,j=0,k=0;
		
		while (i<leftLen && j<rightLen)
		{
			if(left[i]<=right[j])
			{
				a[k]=left[i];
				i++;
			}
			else
			{
				a[k]=right[j];
				j++;
			}
			k++;
		}
		while(i<leftLen)
		{
			a[k]=left[i];
			k++;
			i++;
		}
		while(j<rightLen)
		{
			a[k]=right[j];
			k++;
			j++;
		}
		
		return a;
		
	}



}
