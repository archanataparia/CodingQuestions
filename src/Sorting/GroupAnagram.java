package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*Write a method to sort an array of strings so that all the anagrams are next to each other.*/
public class GroupAnagram {

	public static void main(String[] args) {
		GroupAnagram  ga=new GroupAnagram ();
		String[] input={"cat", "dog","tac","god","act"};
		String[] output=ga.groupAnagram(input);
		System.out.println(output);
	}



	private String[] groupAnagram(String[] input) {
		HashMap<String,String> map=new HashMap<String,String>();//create hash map list to store anagrams for a string
		for(String s:input)
		{
			String sorted=sortString(s);
			System.out.println(sorted+" "+s);
			if(map.containsKey(sorted)){map.put(sorted, map.get(sorted)+", "+s);}
			else
				map.put(sorted, s);
		}
		//convert hash table to array
		int i=0;
		Collection<String> values=map.values();//get collection of values
		ArrayList<String> list=new ArrayList<String>(values);//get value
		System.out.println(values);
		
		return null;
	}

	private String sortString(String s) {
		char[] ch=s.toCharArray();
		Arrays.sort(ch);//sort the array
		return new String(ch);
	}
	
/*second approach
 * public static void sortStringWithAnagrams(String[] stringArray) {
    Arrays.sort(stringArray, new AnagramComparator());
}

public static class AnagramComparator implements Comparator<String> {

    public String getSortedString(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2) {
        return getSortedString(s1).compareTo(getSortedString(s2));
    }

}*/	
	
}
