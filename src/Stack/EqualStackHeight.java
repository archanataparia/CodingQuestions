package Stack;

import java.util.Scanner;
import java.util.Stack;
/*You have three stacks of cylinders where each cylinder has the same diameter,
 *  but they may vary in height. You can change the height of a stack by removing and 
 *  discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the
 same height. This means you must remove zero or more cylinders from the top of zero or 
 more of the three stacks until they're all the same height, then print the height. 
 The removals must be performed in such a way as to maximize the height.
 sample input 
 The first line contains three space-separated integers, , , and , describing the 
 respective number of cylinders in stacks , , and . The subsequent lines 
 describe the respective heights of each cylinder in a stack from top to bottom:
 5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
output 5
*/
class MyStack extends Stack<Integer>
{
	public int height;
	public MyStack(int[] arr)
	{
		this.height=0;	
		for(int i=arr.length-1;i>=0;i--)
		{
			this.height+=arr[i];
			this.push(arr[i]);
		}
	}
	
	public MyStack compare(MyStack stackobj2) 
	{
		if(this.height>stackobj2.height) return this;
		else
		return stackobj2;
	}
	public int unshift()
	{
        int n = this.pop();
        //System.out.println("in unshift "+ n);
        height -= n;
        return n;
    }
	
}//end of class Mystack

public class EqualStackHeight{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2=sc.nextInt();
		int n3 =sc.nextInt();
		int h1[]=new int[n1];
		int h2[]=new int[n2];
		int h3[]=new int[n3];

		for (int i=0;i<n1;i++)
			h1[i]=sc.nextInt();

		for (int i=0;i<n2;i++)
			h2[i]=sc.nextInt();

		for (int i=0;i<n3;i++)
			h3[i]=sc.nextInt();

		 MyStack Stackobj1=new  MyStack(h1);
		 MyStack  Stackobj2=new  MyStack(h2);
		 MyStack  Stackobj3=new  MyStack(h3);
		 
		 while(true)
		 {
	            if(Stackobj1.height == 0 || Stackobj2.height == 0 || Stackobj3.height == 0)
	            {
	            	Stackobj1.height = 0;
	            	System.out.println("in if 1");
	                break;
	            }else
	            {
	                if(Stackobj1.height == Stackobj2.height && Stackobj2.height == Stackobj3.height)
	                    break;
	             }
	             MyStack Stackobj4 =Stackobj1.compare(Stackobj2);
	             Stackobj4 = Stackobj4.compare(Stackobj3);
	             Stackobj4.unshift();
	      }
	       System.out.println("Maxi height is "+Stackobj3.height);
		sc.close();

	
	}}
