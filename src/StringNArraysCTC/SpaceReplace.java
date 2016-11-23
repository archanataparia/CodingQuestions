package StringNArraysCTC;
/*Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if implementing
in Java, please use a character array so that you can perform this operation
in place.)
EXAMPLE
Input: "Mr John Smith
Output: "Mr%20Dohn%20Smith"*/
import java.util.*;
public class SpaceReplace {
	static String spaceReplace(char[] str)
	{
			 int count = 0, length= str.length, newLen, i;
			 //calculate space count
			 for (i = 0; i < length; i++) 
			 {
				 if (str[i] == ' ') count++;
			 }
			 newLen = length + count * 2;
			 if(newLen<length)
				 str[newLen] = '\0';
			 for (i = length-1; i >= 0; i--) {
				 if (str[i] ==' ') 
				 {
					 str[newLen - 1] = '0';
					 str[newLen - 2] = '2';
					 str[newLen - 3] = '%';
					 newLen = newLen - 3;
				 } 
				 else 
				 {
					 str[newLen - 1] = str[i];
					 newLen--;
				 }
			 }
			 return str.toString();
	 }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int len =sc.nextInt();
		String str=  sc.nextLine();
		String result = spaceReplace(str.toCharArray());
		System.out.println(result);
		sc.close();

	}

}
