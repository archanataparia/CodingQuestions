package Tree;

public class Test {
	public static void main(String[] args){
		String[] m={"a1","a2","a3","b1","b2","b3"};
		myTrans(m);
	}
	   
		private static void myTrans(String[] m) {
		    int n = (m.length - 1);

		    int i = 1;
		    for (int start = 1; start < n; start++) {
		        String temp = m[start];
		        m[start] = m[n / 2 + i];
		        System.out.println(m[start]);

		        for (int j = (n / 2 + i); j > start; j--) {
		            m[j] = m[j - 1];
		        }

		        start++;
		        m[start] = temp;
		        System.out.println(m[start]);
		        i++;
		    }
		    for(int k=0;k<m.length;k++) System.out.print(m[k]+" ");;
		      }
}
