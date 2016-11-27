package Queue;

import java.util.Stack;

/*Implement a class which implements a queue using two stacks.*/
public class QueueViaStack {
//Idea is to maintain 2 stacks where stnew has new element on top and stold has old element on top so FIFO will followed
	Stack<Integer> stNew=new Stack<Integer>();
	Stack<Integer> stOld=new Stack<Integer>();

	public static void main(String[] args) {
		QueueViaStack qs=new QueueViaStack();
		qs.add(1);qs.add(2);qs.add(3);qs.add(4);qs.add(5);qs.add(6);
		int o1=qs.remove();int o2=qs.remove();int o3=qs.remove();
		System.out.println(" output "+o1+" "+o3);qs.display();
		

	}
	public int size()
	{
		return stNew.size()+stOld.size();
	}
	public void add(int num)
	{
		stNew.push(num);//stNew will have newest elemt on top
		//display();
	}
	public int remove()
	{
		shifStack();//ensure stOld has current element
		return stOld.pop();
	}
	public int peek()
	{
		shifStack();
		return stOld.peek();
	}
	public void display() {
		
			System.out.print(stOld.peek());
	
	}
	
	private void shifStack() {
		if(stOld.isEmpty())
		{
			while(!stNew.isEmpty())
				stOld.push(stNew.pop());//move elements from new to old
		}
		
	}
}
