package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;
class StackChar
{
	private Stack<Character> stack=new Stack<Character>();
	private String input;
	private String output="";
	
	public StackChar(String s)
	{
		this.input=s;
	}

	public String convertInflixToPostfix() 
	{
		for(int i=0;i<input.length();i++)
		{
			//System.out.println("i "+i+" output "+output);
			char ch=input.charAt(i);
			switch(ch)
			{
				case '+':
				case '-': 
					gotOper(ch,1);//precedence 1
					break;
				case '*':
				case '/': 
					gotOper(ch,2);//precedence 2
					break;
				case '(':
					stack.push(ch);
					break;
				case ')':
					gotParen();
					break;
				default:
					output+=ch;//number or digit (operand)	
			} //end of switch
		}//end of for
		while(!stack.isEmpty()) //pop remaining operator
		{
			Character top=stack.pop();
			output+=top.charValue();
		}
		return output;
	}
			
	private void gotParen() {
	
		while (!stack.isEmpty())
		{
			Character opTop= stack.pop();
			if(opTop.equals('(')) 
				break;
			else 
				output+=opTop.charValue();
		}
		
	}

	private  void gotOper(char opThis, int prec) {
		while (!stack.isEmpty())
		{
			Character opTop= stack.pop();
			if(opTop.equals('(')) 
			{
				stack.push(opTop);//restore (
				break;
			}
			else //its an operator
			{
				int precN;//new precedence
				if(opTop.equals('+')||opTop.equals('-'))
					precN = 1;
				else
					precN = 2;
				if(prec>precN)
				{
					stack.push(opTop);
					break;
				}
				else
					output+=opTop;
			}//end else
		}//end while
		
		stack.push(opThis);//push new operator
	}
}
public class ConvertInflixToPostfix {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Inflix Expression");
		 String str = getString();
		 StackChar st=new StackChar(str);
		 String s= st.convertInflixToPostfix();
		 System.out.println("Postfix Expression is: "+s);
		
	}

	private static String getString() throws IOException
	{

		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ir);
		String s= br.readLine();
		return s;
	}

}

