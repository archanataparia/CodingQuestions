package recursionCTC;

import java.util.Arrays;

/*A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs*/
public class TripleStep {

	public static void main(String[] args) {
		TripleStep ts=new TripleStep();
		int n=5;
		int result1=ts.countWays1(n);
		System.out.println("number of ways are result "+result1);
		int result2=ts.countWays2(n);
		System.out.println("number of ways are result "+result2);

	}

	//brute force approach 
	private int countWays1(int n) {
		if(n==0) return 1;//base case
		else if (n<0) return 0;
		else
		{
			return countWays1(n-1)+ countWays1(n-2)+countWays1(n-3);
		}
	}
	
	//solution using temp cache or memoization
	private int countWays2(int n)
	{
		int[] cache=new int[n+1];
		Arrays.fill(cache, -1);//fill the array with negetive integers to mark
		return countWays2(n,cache);
	}

	private int countWays2(int n, int[] cache) {
		if(n==0) return 1;
		else if(n<0) return 0;
		else if (cache[n]>-1) return cache[n];//check array first before recursion call for existing recursion call
		else//save recursion call in array
		{
			cache[n]=countWays2(n-1,cache) + countWays2(n-2,cache) + countWays2(n-3,cache);
			return cache[n];
		}
	}
}
