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
