package StringNArraysCTC;

import java.util.*;
import java.util.Scanner;

public class MaxRepWordInSrting {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        String s=sc.nextLine();
	        System.out.println("current String");
	        System.out.println(s);
	        repWord(s);
	        //System.out.println("maximum repeted string "+ output);
	}

	private static void repWord(String s) {
		
	Map<String,Integer> map = new HashMap<String,Integer>();

	for(String word:s.split(" ")){
		Integer count= map.get(word);//check available value
		if(count==null) map.put(word, 1);
		else map.put(word, ++count);
		
	}
	
	//iterate through the map and find repeated words
	for (Map.Entry<String, Integer> entry: map.entrySet())
	{
		String word = entry.getKey();
		Integer value = entry.getValue();
		if(value>1)
		{
			System.out.println("duplicate value is: "+word);
		}
		
	}

	}

}
