package Stack;

import java.util.Scanner;
class Stack
{
	private Integer stack[];
	private int top;
	Stack(int size)
	{
		top = -1;
		stack=new Integer[size];
	}
	public void push(Integer num)
	{
		if(isFull()) System.out.println("no space in stack to push");
		stack[++top]=num;
	}
	private boolean isFull() {
		return (top == stack.length-1);
	}
	public Integer pop()
	{
		if(isEmpty()) System.out.println("no elemets in stack to pop");
		return stack[top--];
	}
	private boolean isEmpty() {
		return top ==-1;
		
	}
	public Integer peek()
	{
		return stack[top];
	}
	public void display() {
		while(!isEmpty())
		{
			System.out.print(" " + pop());
		}
	}
	
	
}
public class ArrayImplementationOfStack {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length");
		 int size = in.nextInt();
		Stack stackObj=new Stack(size);
		boolean flag=true;
		while(flag){
		
		 System.out.println("Enter choice number: ");
		 System.out.println("1) Push element: ");
		 System.out.println("2) Pop element: ");
		 System.out.println("3) Peek element: ");
		 System.out.println("4) Display: ");
		 int N = in.nextInt();
		 Integer num;
		 switch(N)
		 {
		 	case 1: System.out.println("Enter number to push: ");
		 			num=in.nextInt();
		 			stackObj.push(num);
		 			break;
		 	case 2: System.out.println(stackObj.pop());
		 			break;
		 	case 3: System.out.println(stackObj.peek());
		 			break;
		 	case 4: stackObj.display();
		 }
		 System.out.println("continue....press y/n ");
		 String ch = in.next();
		 if (ch.equals("n")) flag=false;
		 else {continue;}
	     in.close();
		}
	}

}
