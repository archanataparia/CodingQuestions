package Stack;

import java.util.Scanner;
import java.util.Stack;

class Calculation
{
	private Stack<Integer> stack=new Stack<Integer>();
	private String input;
	//private String output="";
	
	public Calculation(String s)
	{
		this.input=s;
	}
	public Integer evaluatePostfixExpression() {

		char ch;
		 int num1, num2,output; 
		 //scan from left to right
		 for(int i=0;i<input.length();i++)
		 {
			 ch=input.charAt(i);
			 if(ch>='0'&& ch<='9')
			 {
				 //its a operand so push to the stack
				 stack.push((int)ch -'0');//convert char to int
			 }
			 else
			 {	//pop two operands to perform operation
				 num1=stack.pop(); 
				 num2=stack.pop();
				 switch(ch)
				 {
				 case '+':
					 output = num1 +num2;
					 break;
				 case '-':
					 output = num1 -num2;
					 break;
				 case '*':
					 output = num1 *num2;
					 break;
				 case '/':
					 output = num1 /num2;
					 break;
				default:
					output =0;
				 }//end switch
				 stack.push(output);
			 }//end else
		 }//end for
		 return stack.pop();
	}
}
public class EvaluatePostfix {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Expression");
		 String str = in.nextLine();
		 Calculation cal=new Calculation(str);
		Integer result = cal.evaluatePostfixExpression();
		System.out.println("Postfix Expression result is: "+result);
	     in.close();
	     System.out.println("test");

	}
	
}
