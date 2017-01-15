package array;

import java.util.Arrays;

/*Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in array. 
 * Find these two numbers.*/
public class MissingNumberInArray {

	public static void main(String[] args) {
		MissingNumberInArray mn=new MissingNumberInArray();
		int[] a={3,1,3,4,5,7,7};
		int size=a.length;
		mn.missingNDuplicate(a,size);
		//System.out.println(size);
	}
//method 1 sort the array and then check for missing and duplicates O(nLogn)
	private void missingNDuplicate(int[] a, int size) {
		Arrays.sort(a);
		//for(int i=0;i<size;i++) System.out.print(a[i]);
		for(int i=1;i<size;i++)
		{
			if(a[i]==a[i-1]) System.out.println("duplicate number "+a[i]);
			if(a[i]!=i+1 && a[i]!=a[i-1])System.out.println("missing number "+ Math.addExact(i, 1));
		}
	}
	
//method 2 take temp array as given array with same size and check for missing and duplicates O(n)
	//need work
		private void missingNDuplicate1(int[] a, int size) {
			int[] temp=new int[size];//deafult null value is 0 here
			//for(int i=0;i<size;i++) System.out.print(temp[i]);
			for(int i=0;i<size;i++)
			{
				if(temp[a[i]]==0) temp[a[i]]=1;//set index of temp array as per given array element
				if(temp[a[i]]==1) System.out.println("repeating "+a[i]);
			}
			
			
		}
		

}
