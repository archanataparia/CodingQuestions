package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, 
 * the consecutive numbers can be in any order.
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements*/
public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		LongestConsecutiveSubsequence ls=new LongestConsecutiveSubsequence();
		int[] a={1, 9, 3, 10, 4, 20, 2};
		int output=ls.fingTotalSubsequence1(a);
		System.out.println("output is "+output);

	}
	//working code O(nLogn)
	private int fingTotalSubsequence1(int[] a) 
	{
		int max=0;
		int count=0;
		Arrays.sort(a);
		for(int i=1;i<a.length;i++)
		{
			if(Math.abs(a[i]-a[i-1])==1)
				count++;
			if(count>max)max=count;
		}
		return max;
	}
	
	//need work
	private int fingTotalSubsequence(int[] a) {
		//create hash set
		HashSet<Integer> set=new HashSet<Integer>();
		int optLen=0;
		//put all the elementes in the hash set
		for(int i=0;i<a.length;++i)
		{
			set.add(a[i]);
		}	
		System.out.println(set.toString());
		for(int i=1;i<a.length;++i)
		{
			if(set.contains(a[i]-1))//current is the first element of the subsequence 
			{
				//check for next element in the sequence
				int temp=a[i];
				while(set.contains(a[temp])) temp++;
				
				//update the optimal length
				if (optLen<temp-a[i])
                    optLen = temp-a[i];
			}
		}
		return optLen;
	}

}
