package StringNArraysCTC;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class ArrayReverse {
public static void reverseArray(int[] a)
{
	for (int i =a.length-1;i>=0;i--){
	System.out.print(a[i]+" ");
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner in = new Scanner(System.in);
	        int N = in.nextInt();
	        Integer arr[] = new Integer[N];
	        //read integer
	        for(int i=0; i < N; i++)
	        {
	            arr[i] = in.nextInt();
	        }
	        //reverseArray(arr);
	        reverseArrayStack(arr);
	}

	private static void reverseArrayStack(Integer[] arr) {
		// Reverse array with stack
		Stack stack = new Stack();
		for (Integer i: arr){stack.push(i);}
		while (!stack.isEmpty()){System.out.println(stack.pop());};
		
	}

}



      
 