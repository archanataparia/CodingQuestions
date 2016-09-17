package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class ConvertInflixToPostfix {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Inflix Expression");
		 String str = getString();
		 String s= convertInflixToPostfix(str);
		 System.out.println("Postfix Expression is: "+s);
		
	}

	private static String convertInflixToPostfix(String str) {
		String output ="";
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<str.length();i++)
		{
			System.out.println("i "+i+" output "+output);
			char ch=str.charAt(i);
			if(ch=='(')
			{
				System.out.println("inside ch=='(' ");
				stack.push(ch);
			} 
			else if(ch==')')
			{
				Character top=stack.peek();
				while(!(top.equals(new Character('(')) && !(stack.isEmpty())))
				{
					output+=top.charValue();
					stack.pop();
					top=stack.peek();
				}
			}else if(ch =='+'||ch=='-')
			{
				System.out.println("inside (ch =='+'||ch=='-') ");
				if (stack.isEmpty()) stack.push(ch);//stack is empty
				else
				{System.out.println("inside (ch =='+'||ch=='-') else");
					Character top=stack.peek();
					//check with top element
					while(!(stack.isEmpty()||top.equals(new Character ('('))||top.equals(new Character (')'))))
					{
						stack.pop();
						output+=top.charValue();
					}
					stack.push(ch);
				}
				
			}
			else if(ch =='/'||ch=='*')
			{
				if (stack.isEmpty()) stack.push(ch);//stack is empty
				else
				{
					Character top=stack.peek();
					//check with top element
					while(!stack.isEmpty()&&!top.equals(new Character ('+'))&&!top.equals(new Character ('-')))
					{
						stack.pop();
						output+=top.charValue();
					}
					stack.push(ch);
				}
			
			}
			else
			{
				output+=ch;//number or digit (operand)
			}
		}
		//enter remaining char from stack to output
		while(!stack.isEmpty())
		{
			Character top=stack.peek();
			if(!top.equals(new Character('(')))
			{
				stack.pop();
				output+=top.charValue();
			}
		}
		return output;
	}
	private static String getString() throws IOException
	{

		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ir);
		String s= br.readLine();
		return s;
	}

}
