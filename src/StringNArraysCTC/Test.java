package StringNArraysCTC;

public class Test {
	
		    public static void main(String[] args) {
	    	String a="ab";
	    	String b="aa";
	    	boolean flag=checkRotation(a,b);
	    	
	    	System.out.println(flag);
	    }

			private static boolean checkRotation(String a, String b) {
		    	int len = a.length();
		    	int i=0;
		    	if(a.length()!=b.length()) return false; 
		    	while(i<a.length()&&a.charAt(i)==b.charAt(len-1))
		    	{
		    		System.out.println(a.charAt(i));
		    		System.out.println(b.charAt(len));
		    	    i++;
		    		len--;
		    	}
				return true;
			}
	
}
 

