package StringNArraysCTC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




public class Test {
	Stack<Integer> st=new Stack<Integer>();
	    public static void main(String[] args) {
	    	 Test sq=new  Test();
				sq.st.push(1);sq.st.push(6);sq.st.push(3);sq.st.push(4);sq.st.push(5);sq.st.push(6);
				
				System.out.println(sq.checkStackPair());	

	    }
		private boolean checkStackPair() {
			Queue<Integer> q1=new LinkedList<Integer>();
			boolean flag=true;
			
			while(!st.isEmpty())
				q1.add(st.pop());
			while(!q1.isEmpty())
				st.push(q1.remove());
			
			while(!st.isEmpty())
			{
				int n1=st.pop();
				q1.add(n1);
				if(!st.isEmpty())
				{
					int n2=st.pop();
					q1.add(n2);
					if(Math.abs(n1-n2)!=1) flag=false;
				}
			}
			while(!q1.isEmpty())
				st.push(q1.remove());
			return flag;
		}
	
	
}
 

