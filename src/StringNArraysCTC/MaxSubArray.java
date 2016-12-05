package StringNArraysCTC;
//find continuous sequence with the largest sum or maximum sub array 
public class MaxSubArray {
	 public static void main(String[] args) {
	    	//int[] a={6,-8,3,-2,4};
		    	int[] a={-2,-3,4,-1,-2,1,5,-3};
	    	maxSubArray(a); 
	    }

	private static void maxSubArray(int[] a) {
	int end=a.length;
   	 int eindex=0,tempindex=0,sindex=0;
   
   	 int sum=a[0],maxSum=a[0];
   	/*//my first solution
   	 * for(int i=0;i<end;i++)
   	 {
   		 sum=a[i];
   		 for(int j=i+1;j<end;j++)
   		 {
   			 sum+=a[j];
   			 if(sum>maxSum)
   			{
   				 sindex=i;
   				 eindex=j;
   				 maxSum=sum;
   			}   			 
   		 }
   	 }O(n2)*/
   	 
   	for (int i = 1; i < end; i++)
   	{
   	    sum = Math.max(a[i], sum+a[i]);
   	    if(sum>maxSum){
   	        maxSum=sum;
   	       sindex=tempindex;
   	       eindex = i;
   	    }
   	    if(sum < 0){
   	        tempindex = i+1;
   	    }
   	}//O(n)
   	 System.out.println(" maxSum "+maxSum);	
   	 //display array
   	 System.out.print(" max sub array ");
   	for(int i=sindex;i<=eindex;i++)
			System.out.print(" "+a[i]);
	}
}
