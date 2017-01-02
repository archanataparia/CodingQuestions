package sortingNSearching;

import java.util.Arrays;
import java.util.Scanner;

/*You are given two sorted arrays, A and B, where A has a large enough buffer at
the end to hold B. Write a method to merge B into A in sorted order*/
public class SortedMerge {

	public static void main(String[] args) {
		SortedMerge sm=new SortedMerge();
		int[] a= new int[15];
		int[] b= new int[6];
		
		Scanner in = new Scanner(System.in);
		 System.out.println("Enter length a");
		 int N = in.nextInt();
	     System.out.println("Enter Array");
	        for(int i=0; i < N; i++)
	        {
	            a[i] = in.nextInt();
	        }
	         System.out.println("Enter Array b");
	         System.out.println("Enter length a");
			 int N2 = in.nextInt();
		
		        for(int i=0; i < N2; i++)
		        {
		            b[i] = in.nextInt();
		        }
		int[] c=sm.mergeArray(a,b,N,N2);
		System.out.println("result "+Arrays.toString(c));
	}

	private int[] mergeArray(int[] a, int[] b,int aLen,int bLen) {
		int indexA=aLen-1;
		int indexB=bLen-1;
		int mergeIndex=aLen+bLen-1;
		//as array a has buffer space start merging largest element at the end of the array a
		while(indexB>=0 && indexA>=0)//coz b array is shorter and till then we need to compare
		{
			if(indexA>=0 && a[indexA]<b[indexB])
				a[mergeIndex]=b[indexB--];
			else
				a[mergeIndex]=a[indexA--];
			mergeIndex--;
		}
		return a;
	}

}
