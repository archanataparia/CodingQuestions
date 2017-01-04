package StringNArraysCTC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Remove duplicates from a string, do it in-place –
public class RemoveDuplicateFromStringInPlace {

	public static void main(String[] args) {
		String s="Archana";
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

}
