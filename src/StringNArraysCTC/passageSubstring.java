package StringNArraysCTC;
import java.io.*;
import java.util.StringTokenizer;
//need work
public class passageSubstring {
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null) {
	      /*System.out.println(s);
	    	String[] ary = s.split("|");
	    	for(int i=0;i<ary.length;i++) {
	        	
	            System.out.println(ary[i]);
	            
	        }*/
	    	StringTokenizer st=new StringTokenizer(s,"|");
	       String[] string=new String[st.countTokens()];
	        //System.out.println(st.countTokens());
	        int j=0;
	        while (st.hasMoreTokens()&& j<st.countTokens()) {
	        	string[j++]=st.nextToken().toString();
	            System.out.println(string[j]);
	            
	        }
	    }
}
}