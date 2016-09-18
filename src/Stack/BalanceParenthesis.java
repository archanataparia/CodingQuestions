package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalanceParenthesis {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Expression");
		 String str = in.nextLine();
		
		 Boolean result= checkBalParenthesis(str);
		
		 System.out.println("This expression is balanced "+ result);
	     in.close();
	


	}
	//Customize function to convert
	/*public static Character[] toCharacterArray( String s ) {

		   if ( s == null ) {
		     return null;
		   }

		   int len = s.length();
		   Character[] array = new Character[len];
		   for (int i = 0; i < len ; i++) {
		      array[i] = new Character(s.charAt(i));
		   }

		   return array;
		}*/
	
	public static boolean checkBalParenthesis(String s)
	{
		 /*convert string to Character Array
		Character ch[]=toCharacterArray(s);*/
		//create stack object
		 Stack<Character> stack =new Stack<Character>();
		 
		 //scan from left to right
		 for(int i=0;i<s.length();i++)
		 {
			 char c = s.charAt(i);
			 if((c=='{')||(c=='(')||(c=='['))
			{
				 stack.push(c);
			}
			 else if(c == ']') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '[') return false;

	            }else if(c == ')') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '(') return false;

	            }else if(c == '}') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '{') return false;
	            }
		 }
		
		return stack.isEmpty();
	} 
	
	
}
