package StringNArraysCTC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*Given a string write a function to check if it is a permutation of a palindrome 
 * example input Tact Coa
 * output true(permutations: "taco cat", "atco cta")*/
public class PermutationPalindrome {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		
		boolean result= permutationPalindrome(sc.nextLine());
		System.out.println("result is "+result);
		sc.close();

	}

	private static boolean permutationPalindrome(String str) {
		// if string has more than one odd count then its permuation is not palindrom.
		int countOdd =0;
		/*boolean flag=false;
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		
		char[] ch=str.toCharArray();
		for(char c:ch)
		{
			if(map.containsKey(c)) map.put(c, map.get(c)+1);
			else map.put(c, 1);
		}
		
		for(Map.Entry<Character, Integer> entry:map.entrySet())
		{
			Character key=entry.getKey();
			Integer value=entry.getValue();
			if(value%2!=0)
				countOdd++;
		}
		*/int [] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		
		for(char ch:str.toCharArray())
		{
			int x=getCharNumber(ch);
			if(x!=-1)
			{
				table[x]++;
				if(table[x]%2==1) countOdd++;
				else
					countOdd--;
			}
		}
		return countOdd<=1;
	}

	private static int getCharNumber(char val) {
		int a= Character.getNumericValue('a');
		int z= Character.getNumericValue('z');
		if(a<=val && val<=z)
		{
			return val-a;
		}
		return -1;
	}

}
