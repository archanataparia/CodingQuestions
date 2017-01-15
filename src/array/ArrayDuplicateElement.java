package array;

import java.util.*;


public class ArrayDuplicateElement {

	//finding duplicate using hash set
	static void duplicateArray1(String[] str)
	{
		Set<String> set =new HashSet<String>();
		for(String s:str)
		{
			if(!set.add(s)) System.out.println("duplicatre: "+s);
		}
		
	}
	//finding duplicate using hash map/table
		static void duplicateArray2(String[] str)
		{
			Map<String,Integer> map =new HashMap<String,Integer>();
			
			//building hash table with count
			for(String s:str)
			{
				Integer count= map.get(s);//check available value
				if(count==null) map.put(s, 1);
				else map.put(s, ++count);
			}
			
			//print duplicates from hash table
			for(Map.Entry<String,Integer> entry:map.entrySet())
			{
				String key = entry.getKey();
				Integer count = entry.getValue();
				if(count>1)
				System.out.println("Duplicate value is "+key);
			}
			
		}
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int N = in.nextInt();
	       String sarr[] = new String[N];
	        //read integer
	        for(int i=0; i < N; i++)
	        {
	            sarr[i] = in.next();
	        }
	        duplicateArray2(sarr);
	        in.close();

	}

}
