package StringNArraysCTC;
//input-{"a1","a2","a3","b1","b2","b3"} output-a1 b1 a2 b2 a3 b3 
public class ChangeSequenceOfString {

	public static void main(String[] args) {
		String[] s={"a1","a2","a3","b1","b2","b3"};
		myTrans(s);
	}
	private static void myTrans(String[] s) {
	    int len = (s.length - 1);

	    int i = 1;
	    for (int start = 1; start < len; start++) {
	        String temp = s[start];//save starting index as we dont need to change sequence from 0 element we will swap element at 1 position
	        s[start] = s[len / 2 + i];//replace starting index with middle element
	       
	        for (int j = (len / 2 + i); j > start; j--) {
	            s[j] = s[j - 1];//adjust the elements
	        }

	        start++;
	        s[start] = temp;//fill up the hole
	          i++;
	    }
	    for(int k=0;k<s.length;k++) System.out.print(s[k]+" ");;
	      }

}
