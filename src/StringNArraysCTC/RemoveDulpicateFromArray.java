package StringNArraysCTC;

import java.util.*;

public class RemoveDulpicateFromArray {
	


	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter length of Array");
		Integer N = in.nextInt();
		System.out.println("Enter Array");
		String s[]=new String[N];
		for (int i=0; i< N; i++){
			s[i]=in.next();
		}
		//CAlling the method to remove duplicates
		removeDuplicate(s);
		removeDuplicateFromSet(s);

	}

	private static void removeDuplicateFromSet(String[] s) {
		Set<String> set = new HashSet<String>();
		for (String str: s){
			set.add(str);
		}
		
		
	}

	private static void removeDuplicate(String[] s) {
		Arrays.sort(s); //Sort the array with Collection
		System.out.println("****** Sorted String Array *******");
		for (String str : s) {
			System.out.print(" " + str);
		}
		int i=0,j=1;
		while(j<s.length)
		{
			
			if(s[i].equals(s[j]))
			{
				System.out.println(s[j]);
				j++;
			}
			else 
			{ 
				s[++i]=s[j++];
			}
				
		}
		
		
		String[] output = new String[i+1];
		for (int k =0; k< output.length; k++  )
		{
			output[k] = s[k];
		}
		System.out.println("****** Array after duplicate removal *******");
		for (String str : output) {
			System.out.println(str);
		}
	}

}
