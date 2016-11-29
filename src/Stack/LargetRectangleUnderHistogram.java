package Stack;
import java.util.Scanner;
import java.util.Stack;
/*Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit. 

For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 2, 6}. The largest possible rectangle possible is 12*/

public class LargetRectangleUnderHistogram 
{
	Stack<Integer> stack=new Stack<Integer>();//create a stack
	private int maxRectangleUnderHistogram(int[] input)
	{
		int area=0, maxArea=0;
		int i;
		for(i=0;i<input.length;)
		{
			//If stack is empty or bar is higher than the top of stack, then push ‘i’ to stack.
			if(stack.isEmpty()||input[stack.peek()]<=input[i])
				stack.push(i++);//push index to the stack NOT ELEMENT
			else
			{
				int top=stack.pop();//one by one remove all index value from stack 
				//calculate area and max area
					area=input[top]*(stack.isEmpty()?i:i-stack.peek()-1);
				if(area>maxArea)
					maxArea=area;
			}
		}
		while(!stack.isEmpty())
		{
			int top=stack.pop();
			area=input[top]*(stack.isEmpty()?i:i-stack.peek()-1);
			if(area>maxArea)
				maxArea=area;		
		}
		return maxArea;
	}

	public static void main(String[] args) {
		LargetRectangleUnderHistogram  lr=new LargetRectangleUnderHistogram ();
		Scanner in = new Scanner(System.in);
		System.out.println("Enetr Array length");
		int N = in.nextInt();
		System.out.println("Enetr Array");
		int a[] =new int[N];
		for(int i=0;i<N;i++)
		{
			a[i]=in.nextInt();
		}
		System.out.println("Max size is "+lr.maxRectangleUnderHistogram(a));

	}

}
