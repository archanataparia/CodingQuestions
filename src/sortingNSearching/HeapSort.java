package sortingNSearching;

import java.util.Arrays;
import java.util.Scanner;



public class HeapSort {
	private static int HeapSize;
	public static void main(String[] args) {
		HeapSort hp=new HeapSort();
		 	 int arr[] = {12, 11, 13, 5, 6, 7};
		 	 System.out.println(Arrays.toString(arr));
		  
	        hp.heapSort(arr);
	         System.out.println("Sorted array");
	         System.out.println(Arrays.toString(arr));
			 
	 }

	private void heapSort(int[] arr) {
		HeapSize=arr.length;
		int temp;
		//build heap from the given array
		buildHeap(arr);
		
		//take element out from heap and place in sorted order
		for(int i=arr.length-1;i>0;i--)
		{
			//swap first and last element in the array
			temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			HeapSize=HeapSize-1;
			//swap largest element in the heap
			maxHeapify(arr,0);
		}
		
	}

	private void buildHeap(int[] arr) {
		HeapSize=arr.length-1;
		for(int i=HeapSize/2;i>=0;i--)
			maxHeapify(arr,i);	
	}

	//method to build a heap and swap max element to the root
	private void maxHeapify(int[] arr, int index) {
		
		int temp;
		int larger=index;//initialize largest with given index
		int left=2*index+1;//formula to calculate left index in a heap
		int right=2*index+2;//formula to calculate right index in a heap
		//System.out.println("callingsecond");System.out.println("HeapSize "+HeapSize);
		//compare to find largest index
		if( left<HeapSize && arr[left]>arr[larger] )
			larger=left;
		if(right<HeapSize && arr[right]>arr[larger] )
			larger=right;
		
		//if root is not largest then swap;
		if(larger!=index)
		{
			//swap the root
			temp=arr[index];
			arr[index]=arr[larger];
			arr[larger]=temp;
			
			//recursively check for max heap in subtree
			maxHeapify(arr,larger);
		}
		
	}
	
}
