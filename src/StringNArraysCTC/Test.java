package StringNArraysCTC;

import java.io.*;

public class Test {
	static void printTwoMaxNumbers(int[] nums){
        int maxOne = 0;
        int maxTwo = 0;
        for(int n:nums){
            if(maxOne < n){
                maxTwo = maxOne;
                maxOne =n;
            } else if(maxTwo < n){
                maxTwo = n;
            }
        }
        
        System.out.println("First Max Number: "+maxOne);
        System.out.println("Second Max Number: "+maxTwo);
    }
	
	public static String getInput() throws IOException
	{

		InputStreamReader ir=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ir);
		String s= br.readLine();
		//conversion from string to other
		int i=Integer.parseInt(s);
		long l= Long.parseLong(s);
		double d= Double.valueOf(s);
		System.out.println("int: "+i+" long: "+l+" double "+d);
		return s;
	}
	
	
	
     	public static void main(String[] args)  {
		int num[] = {5,34,78,2,45,1,99,23};
		
		try{
			System.out.println("value of s: "+getInput());
		}
		catch (IOException e)
		{
			System.out.println("execption ocurs");
		}
		
            printTwoMaxNumbers(num);
 
  
	  }
	}

/*import java.util.HashMap;
import java.util.Map;

public class IBMEmployeeConflict {

    public static String solveConflict(Map<String, String> hm,String s1,String s2)
    {
        boolean done=false;
        String answer="";
        while(!(done))
        {
            if(hm.get(s1)==hm.get(s2))
            {
                done=true;
                answer= hm.get(s1);
            }
            else if(hm.get(s1)==s2)
            {
                done=true;
                answer=  s2;
            }
            else if(hm.get(s2)==s1)
            {
                done=true;
                answer=  s1;
            }
            else
            {
                s1=hm.get(s1);
                s2=hm.get(s2);
            }
        }
        return answer;
    }
    public static void main(String args[])
    {
        Map<String,String> hm=new HashMap<String, String>();
        hm.put("Mary","Frank");
        hm.put("Sam","Frank");
        hm.put("Bob","Mary");
        hm.put("Katie","Sam");
        hm.put("Pete","Sam");
        hm.put("John","Bob");

        String employee1="Bob";
        String employee2="Katie";

        System.out.println(solveConflict(hm, employee1, employee2));

		 String s="Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Bob,Katie";
		    
		   String[] sarr = s.split(",");
		   String temp1=null,temp2=null;
	    for(int i=0;i<sarr.length-2;i++)
	    {
	    	
	    	 String[] temp=new String[2];
	    	 if(sarr[i].contains("->")) 
	    	 {
	    		 temp=sarr[i].split("->");
	    		 tree.createTree(temp[0]);
	    		 tree.createTree(temp[1]);
	    	 }
	    }
	    tree.displayTree();
	    temp1=sarr[sarr.length-1];
	    temp2=sarr[sarr.length-2];
	    }
    }
}
*/
