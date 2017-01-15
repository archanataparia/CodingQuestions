package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
	
	private void insertAtBottom(Stack<Integer> stack, int data) {
		System.out.println("calling inset");
		System.out.println("data in insert "+data);
		System.out.println("stack in insert"+stack);
		
		int temp=stack.pop();
		if(stack.size()!=0)
			insertAtBottom(stack, data);
		else
			stack.push(data);
		stack.push(temp);
		System.out.println("stack in insert"+stack);
		
	}

		
		private void reverseStack(Stack<Integer> stack)
		{
			/*if another stack is allowed
			 Stack<Integer> rev=new Stack<Integer>();
			while (!stack.isEmpty())
				rev.push(stack.pop());
			System.out.println(rev);*/
			
			int data=stack.pop();
			if(stack.size()!=1)
			{
				reverseStack(stack);
			}
			
			System.out.println("data in rev "+data);
			System.out.println("stack in rev"+stack);
			
			insertAtBottom(stack,data);
			
			System.out.println("calling reverse");
			
		}
		
	
	public static void main(String[] args) {
		ReverseStack obj = new ReverseStack();
		Stack<Integer> stack=new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enetr Number of elements");
		int N = in.nextInt();
		while (N-->0)
		{
			int num =in.nextInt();
			stack.push(num);
		}
		System.out.println(stack);
		obj.reverseStack(stack);
		System.out.println(stack);
	}

}
