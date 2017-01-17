package sortingNSearching;

import java.util.Arrays;

/*In an array of integers a peak is an element which is greater than or equal to adjacent integers and valley is an element
 * which is less than or equal to the adjacent integers.
 * Example-{5,8,6,2,3,4,6} peak={8,6} and valley={5,2} 
 * Given an array of integers sort the array into an alternating sequence of peak and valley
 * Input={5,3,1,2,3}
 * Output={5,1,3,2,3}*/
public class PeaksAndValleys {

	public static void main(String[] args) {
		int[] a={5,3,1,2,3};
		int[] a1={0,1,4,7,8,9};//output should be 1,0,7,4,9,8
		System.out.println(Arrays.toString(a));
		PeaksAndValleys pv=new PeaksAndValleys();
		System.out.println("Array sorted in alternating sequence of peak and valley");
		int[] output=pv.sortArray(a);
		System.out.println(Arrays.toString(output));
	}

	private int[] sortArray(int[] a) {
		Arrays.sort(a);//sort the array in ascending order
		//System.out.println(Arrays.toString(a));
		for(int i=1;i<a.length;i+=2)
		{
			int temp=a[i-1];
			a[i-1]=a[i];
			a[i]=temp;
		}
		return a;
	}
	
	//with unsorted array
	private int[] sortArray1(int[] a)
	{
		//compare left right and cnter index and find max value and swap it
		for(int i=1;i<a.length;i+=2)
		{
			int max=findMaxIndex(a,i-1,i,i+1);
			//System.out.println(i+ " "+max);
			if(i!=max && max<a.length)
			{
				//swap the element
				int temp=a[i];
				a[i]=a[max];
				a[max]=temp;
			}
		}
		return a;
	}

	private int findMaxIndex(int[] a, int left, int middle, int right) {
		int leftValue=left>=0 && left<a.length?a[left]:Integer.MIN_VALUE;
		int middelValue=middle>=0 && middle<a.length?a[middle]:Integer.MIN_VALUE;
		int rightValue=right>=0 && right<a.length?a[right]:Integer.MIN_VALUE;
		//System.out.println("left "+leftValue+" right "+rightValue+" middle "+middelValue);
		int max=Math.max(leftValue, Math.max(middelValue, rightValue));
		if(leftValue==max) return leftValue;
		else if (middelValue==max) return middelValue;
		else return rightValue;
	}

}
