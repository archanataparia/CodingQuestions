package array;

public class MaxDiffArray {

	public static void main(String[] args) {
		//int[] a={6,1,5,2,8};output is 7
		//int[] a={80,2,6,3,100};output is 98
		int[] a={1,2,6,80,100};
    	int output=maxDiffInArray(a); 
    	System.out.println("result is "+output);
	}

	private static int maxDiffInArray(int[] a) {
		int min=a[0];
		int diff=0;
		int maxDiff=0;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<min)
				min=a[i];
			diff=Math.abs(a[i]-min);
			if(diff>maxDiff)
				maxDiff=diff;
		}
		return maxDiff;
	}

}
