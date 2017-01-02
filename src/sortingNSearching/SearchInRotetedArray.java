package sortingNSearching;
/*Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element
 *  in the array. You may assume that the array was originally sorted in increasing order.
EXAMPLE
Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
Output: 8  */
public class SearchInRotetedArray {

	public static void main(String[] args) {
		int[] a={15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		SearchInRotetedArray sr=new SearchInRotetedArray();
		int index=sr.search(a,3,0,a.length-1);
		System.out.println("index is "+index);
	}

	private int search(int[] a, int num,int start,int end) {
		int mid=(start+end)/2;
		if(start>end) return -1;
		if(a[mid]==num) return mid;
		
		//one of the right or left side is normally ordered so use the ordered side to find which side to search 
		if(a[start]<a[mid])//left side is normally ordered
		{
			if(num>=a[start] && num<=a[mid]) 
				return search(a,num,start,mid-1);//search left
			else
				return search(a,num,mid+1,end);//search right
		}
		else if(a[start]>a[mid])//right side is normally ordered
		{
			if(num>=a[mid] && num<=a[end])
				return search(a,num,mid+1,end);//search right
			else
				return search(a,num,start,mid-1);//search left
		}
		else 
			return -1;
		
	}

}
