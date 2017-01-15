package recursionCTC;
//need work
import java.util.ArrayList;
import java.util.HashMap;

//Write a method to compute all permutations of a string.
public class PermutationString {

	public static void main(String[] args) {
		PermutationString ps=new PermutationString();
		String s1="abc";
		String s2="aabc";
		ArrayList<String> list=ps.permuationWithoutDup(s1);
		System.out.println(list);
		ArrayList<String> list2=ps.permuationWithoutDup2(s2);
		System.out.println(list2);
	}

	//function to find permutation of unique string
	private ArrayList<String> permuationWithoutDup(String s) {
		ArrayList<String> list=new ArrayList<String>();
		permuationWithoutDup("",s,list);
		return list;
	}

	private void permuationWithoutDup(String prefix, String reminder, ArrayList<String> list) {
		if(reminder.length()==0) list.add(prefix);
		int len =reminder.length();
		for(int i=0; i<len;i++)
		{
			String before=reminder.substring(0, i);
			String after =reminder.substring(i+1, len);
			char ch=reminder.charAt(i);
			permuationWithoutDup(prefix+ch,before+after,list);
		}
	}

	//function to find permutation of duplicate string--result will not have duplicates
	private ArrayList<String> permuationWithoutDup2(String s) {
		ArrayList<String> list=new ArrayList<String>();
		HashMap<Character, Integer> map=buildHashMap(s);
		permuationWithoutDup2("",s.length(),list,map);
		return list;
	}

	private HashMap<Character, Integer> buildHashMap(String s)
	{
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();//use hash map to tack unique elements
		
		for(char c:s.toCharArray())//calculate number of occurence of the character
		{
				if(map.containsKey(c))
					map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		return map;
	}
	
	private void permuationWithoutDup2(String prefix, int reminder, ArrayList<String> list,HashMap<Character, Integer> map) 
	{
		if(reminder==0) 
		{
			list.add(prefix);
			return;
		}
		
		for(Character c:map.keySet())//itration through ghash map
		{
			int count=map.get(c);
			if(count>1)
			{
				map.put(c, count-1);
				permuationWithoutDup2(prefix+c,reminder-1,list,map);
				map.put(c, count);
			}
		}
	}
}
