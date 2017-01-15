package Stack;
/*How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should
all operate in O(1) time.*/
class StackWithMin
{
	private int top;
	private int[] stack;
	private int min=0;
	StackWithMin(int size)
	{
		top=-1;
		stack=new int[size];
	}
	
	public void push(int num)
	{
		if(top>stack.length-1) return;
		if(top==-1) min=num;
		if(min>num) min=num;
		stack[++top]=num;
	}
	public int pop()
	{
		if(top==-1) return 0;
		return stack[top--];
	}
	public int getMin()
	{
		return min;
	}
	
}
public class StackMin {

	public static void main(String[] args) {
		StackWithMin sm=new StackWithMin(10);
		sm.push(3);
		sm.push(6);
		sm.push(1);
		sm.push(10);
		sm.push(11);
		sm.push(23);
		sm.push(-2);
		sm.push(34);
		
		System.out.println(sm.getMin());

	}

}
