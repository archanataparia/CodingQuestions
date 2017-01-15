package Stack;
import java.util.*;
import java.util.Stack;
public class SortStack {
/*Sort a stack such that the smallest items are on the top. 
you can use additional temp stack but can not copy stack data to other ds such as array*/
	
	public static void main(String[] args) {
		 Stack<Integer> stack = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length");
			 int size = in.nextInt();
			 while (size-->0)
				{
					int num =in.nextInt();
					stack.push(num);
					//stack.push(5);stack.push(10);stack.push(12);stack.push(3);stack.push(8);
				}
			 Stack result=sortStack(stack);
			 System.out.println(result);
			 sortStackRec(stack);
			 new SortStack().sortStack(stack);
		      System.out.println("Stack After Sort : " + Arrays.toString(stack.toArray()));

	}
//sort stack using recursion
private static void sortStackRec(Stack<Integer> stack) {
	if(!stack.isEmpty())
	{
	int temp=stack.pop();
	sortStackRec(stack);
	sortedInsert(stack,temp);
	}
	
}

private static void sortedInsert(Stack<Integer> stack, int temp) {
	if(stack.isEmpty()||stack.peek()<temp)
	{
		stack.push(temp);
	}
	else
	{
		int t=stack.pop();
		sortedInsert(stack,temp);
		stack.push(t);
	}
	
}
//sort stack using iteration
private static Stack sortStack(Stack<Integer> input) 
{
	//create temp stack
	Stack<Integer> temp=new Stack<Integer>();
	
	while(!input.isEmpty())
	{
		int num=input.pop();
		while(!temp.isEmpty()&&temp.peek()>num)
		{
			input.push(temp.pop());
		}
		temp.push(num);
	}
	return temp;
	
}

}
