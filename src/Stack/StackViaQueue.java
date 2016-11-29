package Stack;
import java.util.Queue;
import java.util.LinkedList;

import Queue.QueueViaStack;
/*Implement a class which implements a stack using two queues.*/
public class StackViaQueue {
	//Idea is to maintain 2 stacks where stnew has new element on top and stold has old element on top so FIFO will followed
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();

		public static void main(String[] args) {
			 StackViaQueue sq=new  StackViaQueue();
			sq.push(1);sq.push(2);sq.push(3);sq.push(4);sq.push(5);sq.push(6);
			
			System.out.println(" output "+sq.pop()+ " "+sq.pop()+ " "+sq.pop()+ " "+sq.pop()+ " "+sq.pop()+" "+sq.pop());	
		}
		
		private int pop() {
			// if q1 is not empty then transfer n-1 element to q2 and then dequeue the last number and return it
			if(!q1.isEmpty())
			{
				for(int i=0;i<q1.size()-1;i++)
					q2.add(q1.remove());
				return q1.remove();
			}
			// if q2 is not empty then transfer n-1 element to q1 and then dequeue the last number and return it
			else
			{
				for(int i=0;i<q2.size()-1;i++)
					q1.add(q2.remove());
				return q2.remove();
			}
			
		}
		private void push(int num) {
			// check for the empty queue and push the number in opposite one
			if(q1.isEmpty()) 
				q2.add(num);
			else
				q1.add(num);	
		}

}
