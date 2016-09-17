package Stack;

import java.util.Scanner;
import java.util.Stack;

public class TemplateStack {
public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length");
		 int size = in.nextInt();
		
		 Stack<Integer> stack =new Stack<Integer>();
		 while(size-->0)
		 {
			 Integer n= in.nextInt();
			 stack.push(n);
		 }
		
		
		
		
		//display
		for(int i=0;i<stack.size();i++)System.out.print(" "+stack.elementAt(i));
		
		System.out.println(" pop");
		//pop
		while(!stack.isEmpty())
		{
			System.out.print(" "+stack.pop());
		}
	     in.close();
	
	}


}
