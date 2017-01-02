package sortingNSearching;
import java.util.*;

//to perform binary search sort the data first..here I am using bubble sort

public class BinarySearch {
//Bubble sort	
static int[] BubbleSort(int[] a)
 {
	 int flag =0;
	 int temp;
	 for(int i=(a.length)-1;i>=0;i--){
		for(int j=0;j<i;j++)
		{
			if(a[j]>a[j+1])
			{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
				flag=1;
			}
		}
		if(flag==0) break;
	 }
	 return a;
 }
//Binary search
static String BinarySearch(int[] a,int n)
	{
		int start=0, end= a.length -1;
		int mid;
		while(start<=end)
		{
			mid = (start+end)/2;
			//int to string conversion
			if(a[mid]==n) return String.valueOf(mid);
			else
			{
				if(a[mid]<n) start = mid+1;
				else end = mid-1;
			}
		}
		return "no match found";
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        a = BubbleSort(a);
        for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
        System.out.print("Enter number to search ");
        int n = sc.nextInt();
        String result= BinarySearch(a, n);
        System.out.print("Result "+result);
	}

}


/*_______________________________min value search through binary search method if array is rotated or normal sort_____________________________
public class Solution {
static int BinarySearch(int[] a)
	{
		int start=0, end= a.length -1;
		int mid = (start+end)/2;
		int min= a[0];
		while(start<=end)
		{
			mid = (start+end)/2;
			if(a[mid]<min) min = a[mid];
			if(a[mid]>a[end]) 
					start = mid;
			else
					end=mid-1;
		}
		return min;
		
}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
       
      int result= BinarySearch(a);
        System.out.print("Result "+result);
	}

}*/
