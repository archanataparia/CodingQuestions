package Stack;

import java.util.Scanner;
import java.util.Stack;
//this code need rework 
public class EvaluatePostfix {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Expression");
		 String str = in.nextLine();
		
		evaluatePostfixExpression(str);
		
		 
	     in.close();
	     System.out.println("test2");

	}
	
	private static void evaluatePostfixExpression(String str) {

		//create stack object
		 Stack<Character> stack =new Stack<Character>();
		 
		 //scan from left to right
		 for(int i=0;i<str.length();i++)
		 {
			 char ch=str.charAt(i);
			 if(ch>='0'&& ch<='9')
			 {
				 //its a operand so push to the stack
				 stack.push(ch);
			 }
			 else
			 {	//pop two operands to perform operation
				 int op1=(int)stack.pop(); 
				 int op2=(int)stack.pop();
				 char result=(char)perform(ch,op1,op2);
				stack.push(result); 
			 }
		 }
		 char top =stack.pop();
		 System.out.println("Output is  "+ top);
	}

	private static int perform(Character s, int a, int b) {
		if(s.equals(new Character('*'))) return a * b;
		else if(s.equals(new Character('/'))) return a / b;
		else if(s.equals(new Character('-'))) return a - b;
		else if(s.equals(new Character('+'))) return a +b;
		else return 0;
		
	}

}
