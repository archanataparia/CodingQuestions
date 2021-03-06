package StringNArraysCTC;
import java.util.*;
public class ReverseString {

	//with char array
	public static void reverse1(String s)
	{
		char[] cArr= s.toCharArray();
		for(int i=cArr.length-1; i>=0;i--)
		{
			System.out.print(cArr[i]);
		}
	}
	//with stack
	public static String reverse2(String s)
	{
		
		Stack<String> stack=new Stack<String>();
		String str="";
		for(int i =0; i<s.length();i++)
		{
			stack.push(String.valueOf(s.charAt(i)));
		}
		while(!stack.isEmpty())
		{
			str = str.concat(stack.pop());
		}
		return str;
	}
	
	//reversed string using Stringbuffer reverse function
	static String reverse3(String s)
	{
		String reverseStr = new StringBuffer(s).reverse().toString();
		return reverseStr;
    
	}
	//with string builder
	static String reverse4(String s)
	{
		char[] ch=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=ch.length-1;i>=0;i--)
		{
			sb.append(String.valueOf(ch[i]));
		}
		return sb.toString();
		 
	}
	//using recursion and substring function
	static String reverse5(String s)
	{
		//base condition to handle one char and empty string
		if(s.length()==1) return s;
		return reverse5(s.substring(1))+s.charAt(0);
		
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=  sc.nextLine();
	
		System.out.println("with char Array ");
		reverse1(str);
		
		System.out.println("with stack ");
		String revStr = reverse2(str);
		System.out.print (revStr);
		
		System.out.println("with string buffer reverse  function");
		String revStr3 = reverse3(str);
		System.out.print (revStr3);
		
		System.out.println("with recursion");
		String revStr5 = reverse5(str);
		System.out.print(revStr5);
		
		System.out.println();
		System.out.println("Hello Watson");
		String output = reverseCase("Thou art thyself though not a Montague - from Romeo and Juliet");
		System.out.print(output);
		sc.close();
	}
	
	/*Reverse a string like -----
	 * Hello Watson output is Nostaw Olleh
	 * Thou art thyself though not a Montague - from Romeo and Juliet 
	 * output is Teiluj Dna Oemor Morf - Eugatnom A Ton Hguoht Flesyht Tra Uoht
	 * --------------*/
	private static String reverseCase(String string) {
		boolean flag= false;
		StringBuilder result=new StringBuilder();
		string=string.toLowerCase();
		for(int i=string.length()-1;i>=0;i--)
		{	
			String temp = String.valueOf(string.charAt(i));
			if((i==string.length()-1))
			 result.append(string.toUpperCase().charAt(i));
			else if (flag==true)
			{
				result.append(string.toUpperCase().charAt(i));
				flag=false;
			}
			else
				 result.append(string.charAt(i));
			if (temp.matches(" ")) flag=true;
		}
		return result.toString();
	}

}
