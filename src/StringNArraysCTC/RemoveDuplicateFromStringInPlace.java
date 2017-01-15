package StringNArraysCTC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Remove duplicates from a string, do it in-place –
public class RemoveDuplicateFromStringInPlace {

	public static void main(String[] args) {
		String s="archana";
		RemoveDuplicateFromStringInPlace rd=new RemoveDuplicateFromStringInPlace();
		rd.removeDuplicate(s);
		//System.out.println(output);
	}

	private void removeDuplicate(String s) {
		char[] ch=s.toCharArray();
		Set<Character> set=new HashSet<Character>();
		for(char c:ch)
		{
			set.add(c);
		}
		for(char c:set)
		{
			System.out.print(c);
		}	
	}
/*
	private void removeDuplicate1(String s) {
		char[] ch=s.toCharArray();
		Arrays.sort(ch);//sort the array
		for(char c:ch)
		{
			System.out.println(c);
		}
		
		int j=0;
		for(int i=1;i<=ch.length-1;i++)//remove duplicates in sorted array
		{
			if(ch[i]!=ch[i-1])
			{
				ch[j]=ch[i-1];
				j++;
			}
		}
		//remove extra character
		for(int i=0;i<=j;i++)System.out.print(ch[i]);
		for(char c:ch)
		{
			System.out.println(c);
		}	
			
	}*/
}
