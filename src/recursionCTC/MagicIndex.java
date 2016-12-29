package recursionCTC;
/*A magic index in an array A[0.. .n-1] is defined to be an index such that A[i]= i. 
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
FOLLOW UP
What if the values are not distinct?*/
public class MagicIndex {
	public static void main(String[] args) {
		MagicIndex mi=new MagicIndex();
		int[] a={-10,-5,2,2,3,4,7,9,12,13};
		int result=mi.findMagicIndex(a);
		System.out.println("magic index "+result);
		int result1=mi.findMagicIndexFast(a);
		System.out.println("magic index "+result1);
	}

	//brute force approach 
	private int findMagicIndex(int[] a) {
	int len=a.length;
	for(int i=0;i<len;i++)
	{
		if(a[i]==i)
			return i;
	}
		return -1;
	}

	//solution same as binary search for non distinct values
	private int findMagicIndexFast(int[] a)
	{
		return findMagicIndexFast(a,0,a.length-1);
	}

	private int findMagicIndexFast(int[] a, int start, int end) {
		if(start>end) return -1;//base condition
		int mid=(start+end)/2;
		int midVal=a[mid];
		if(midVal==mid) return mid;
		
		//search left
		int leftIndex=Math.min(mid-1, midVal);
		int left=findMagicIndexFast(a,start,leftIndex);
		if(left>=0) return left;
		
		//search right
		int rightIndex=Math.max(mid+1, midVal);
		int right=findMagicIndexFast(a,rightIndex,end);
		if(right>=0) return right;
		return -1;
		}
}
