package StringNArraysCTC;
/*Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.*/
import java.io.*;
import java.util.*;

public class Compression {
	//Approach1 using string builder class
    static String compress(String str) 
    {
    
    	StringBuilder output = new StringBuilder();
    	int count=1,length=str.length();
    	char prev = str.charAt(0);
    	for(int i=1;i<length;i++)
	      {
	        if(str.charAt(i) == prev){count++;}
	        else
	        {
	        	output.append(prev);
	        	output.append(count);
	        	prev=str.charAt(i);
	        	count=1;
	        }
	      }
    	 output.append(prev);
     	 output.append(count);
    	return output.toString();	
    	
    }
    




public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    String result = compress(str);
    System.out.println(result);
    in.close();
}
}

