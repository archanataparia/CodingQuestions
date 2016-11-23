package StringNArraysCTC;
/*Given two strings, write a method to decide if one is a permutation of the other*/
import java.util.*;
public class PermutationString {
static boolean strCheck(String str1,String str2) 
	{
		if(str1.length()!=str2.length()) return false;//check length of two strings
		char[] chArr1=str1.toCharArray();
		char[] chArr2=str2.toCharArray();
		
		//sort two char arrays
		Arrays.sort(chArr1);
		Arrays.sort(chArr2);
		//compare two char values
		return Arrays.equals(chArr1, chArr2);
	}

/*Generating all permutations of a given string*/

public static void permutation(String str) { 
   permutation("", str); 
}
/* * Recursive method which actually prints all permutations * of given String, but since we are passing an empty String *
*  as current permutation to start with, * I have made this method private and didn't exposed it to client. 
*/
private static void permutation(String prefix, String str) {
   int n = str.length();
   if (n == 0) System.out.println(prefix);
   else {
       for (int i = 0; i < n; i++)
           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
   }
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1=  sc.nextLine();
		String str2=  sc.nextLine();
		Boolean result = strCheck(str1, str2);
		System.out.println(result);
		System.out.println("Enter String to generate permutation");
		
		permutation(sc.nextLine());
		sc.close();

	}

}

/*/** based on CTC 6th edition
 * List permutation of a string
 * 
 * @param s the input string
 * @return  the list of permutation
 
public static ArrayList<String> permutation(String s) {
    // The result
    ArrayList<String> res = new ArrayList<String>();
    // If input string's length is 1, return {s}
    if (s.length() == 1) {
        res.add(s);
    } else if (s.length() > 1) {
        int lastIndex = s.length() - 1;
        // Find out the last character
        String last = s.substring(lastIndex);
        // Rest of the string
        String rest = s.substring(0, lastIndex);
        // Perform permutation on the rest string and
        // merge with the last character
        res = merge(permutation(rest), last);
    }
    return res;
}

/**
 * @param list a result of permutation, e.g. {"ab", "ba"}
 * @param c    the last character
 * @return     a merged new list, e.g. {"cab", "acb" ... }
 
public static ArrayList<String> merge(ArrayList<String> list, String c) {
    ArrayList<String> res = new ArrayList<String>();
    // Loop through all the string in the list
    for (String s : list) {
        // For each string, insert the last character to all possible postions
        // and add them to the new list
        for (int i = 0; i <= s.length(); ++i) {
            String ps = new StringBuffer(s).insert(i, c).toString();
            res.add(ps);
        }
    }
    return res;
}*/
