package StringNArraysCTC;

/*CTC 1.1-pg-73 Implement an algorithm to determine if a string has all unique characters. */

import java.util.*;
public class Unique_char_String_check {
	//if other ds use is allowed we can use hash set
	boolean checkString(String s)
	{
		boolean result;
		HashSet<Character> set = new HashSet<Character>();//set is useful for eliminate duplicate
		for(char ch: s.toCharArray())
		{
			if(!(set.add(ch)) ) return false;
		}
		result=true;
		return result;
			
		}
	//if you cannot use additional data structures-book solution

	 boolean checkString2(String str) 
	 {
		 if (str.length() > 256) return false;
		 boolean[] char_set = new boolean[256];
		 for (int i = 0; i < str.length(); i++) 
		 {
			 int val = str.charAt(i);
			 //System.out.println(str.charAt(i));
			 if (char_set[val]) { // Already found this char in string
				 return false;}
			 char_set[val] = true;
		 }
		return true;
	 }
	 
	static void findDuplicateChars(String str){
	        
	        Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
	        char[] chrs = str.toCharArray();
	        for(Character ch:chrs){
	            if(dupMap.containsKey(ch)){
	                dupMap.put(ch, dupMap.get(ch)+1);
	            } else {
	                dupMap.put(ch, 1);
	            }
	        }
	        Set<Character> keys = dupMap.keySet();
	        for(Character ch:keys){
	            if(dupMap.get(ch) > 1){
	                System.out.println(ch+"--->"+dupMap.get(ch));
	            }
	        }
	        //or
	        for (Map.Entry<Character, Integer> entry: dupMap.entrySet())
	    	{
	    		Character word = entry.getKey();
	    		Integer value = entry.getValue();
	    		if(value>1)
	    		{
	    			System.out.println("duplicate value is: "+word+" and count is "+ value);
	    		}
	    		
	    	}
	 }
	public static void main(String[] args)
	{
		Unique_char_String_check obj=new Unique_char_String_check();
		Scanner sc = new Scanner(System.in);
		String s =sc.nextLine();
		boolean result=obj.checkString2(s);
		System.out.println(result);
		findDuplicateChars(s);
		
		sc.close();
	}
	
	
   


}
