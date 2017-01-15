package Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*In a stack how do check whether each successive pair of numbers in the stack is consecutive or not
 * for ex [4,5,-2,-3,1,10,5,6,20] then the output should be true coz if list is having odd number top can left out*/
public class CheckConsecutivePairInStack {
	Stack<Integer> st=new Stack<Integer>();
    
	public static void main(String[] args) {
    	CheckConsecutivePairInStack sq=new  CheckConsecutivePairInStack();
			sq.st.push(1);sq.st.push(2);sq.st.push(3);sq.st.push(4);sq.st.push(5);sq.st.push(6);
			
			System.out.println(sq.st);
			System.out.println(sq.checkStackPair());	
    }
	private boolean checkStackPair() {
		Queue<Integer> q1=new LinkedList<Integer>();//create queue object
		
		
		while(!st.isEmpty())
			q1.add(st.pop());//add all stack elements in queue
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
				if(Math.abs(n1-n2)!=1) return false;
			}
		}
		while(!q1.isEmpty())
			st.push(q1.remove());
		return true;
	}

}
