package StringNArraysCTC;

import java.util.Scanner;

/*1.8 Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").*/
public class IsSubtracting {

	static boolean isSubstring(String s1, String s2)
	{
		if(s1.equals(s2)) return false;
		if(s1.length()==s2.length())
		{
			String s3 = s1 +s1;
			if(s3.contains(s2)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 =sc.nextLine();
		String s2 =sc.nextLine();
		boolean result=isSubstring(s1, s2);
		System.out.println(result);
		sc.close();

	}

}
