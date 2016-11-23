package StringNArraysCTC;

import java.util.Scanner;

/*three type of edit can be performed o string: insert a char, delete a char and replace a char. Given two 
 * string write a function to check if they are one edit away.
 * example: pale, ple -true
 * pales, pale-true,
 * pale, bale-true
 * pale, bae-false*/
public class OneEditAway {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter both String");
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		boolean result= oneEditAway(s1,s2);
		System.out.println("result is "+result);
		sc.close();

	}

	private static boolean oneEditAway(String str1, String str2) {
		
		if(Math.abs(str1.length()-str2.length())>1) return false;//length difference can not be more than 1
		
		//arrange string as per length shorter is second
		String s1=str1.length()<str2.length()?str1:str2;
		String s2=str1.length()<str2.length()?str2:str1;
		
		int index1=0,index2=0;
		boolean foundDiff=false;
		
		while(index1<s1.length()&&index2<s2.length())
		{
			if(s1.charAt(index1)!=s2.charAt(index2))
			{
				if(foundDiff)return false;//ensure it is first difference
				foundDiff=true;
				if(s1.length()==s2.length())
					index1++;//on replace move shorter
			}
			else
					index1++;//if matching move shorter
			index2++;//always move pointer for longer string
			
		}
		
		return true;
	}

}
