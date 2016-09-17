package Queue;

import java.util.Scanner;
class PQueue
{
	private Integer pqueue[];
	private Integer nItem;
	PQueue(int size)
	{
		pqueue=new Integer[size];
		nItem=0;
		
	}
	private boolean isFull() {
		return (nItem == pqueue.length-1);
	}
	private boolean isEmpty() {
		return nItem ==0;
		
	}
	public void display() {
		for(int i=0;i<nItem;i++)
		{
			System.out.print(" " + pqueue[i]);
		}
	}
	
	public void enqueue(Integer num)
	{
		int i;
		if(isFull())
		{
			System.out.println("Queue is full");
		}
		else if(isEmpty())
		{
			pqueue[nItem++]=num;
		}
		else
		{
			for(i=nItem-1;i>=0;i--)
			{
				if(num>pqueue[i])
				{//if num large then shift upward 
					pqueue[i+1]=pqueue[i];	
				}
				else
					break;
			}
			pqueue[i+1]=num;
			nItem++;//insert in queue as per priority
		}
	}
	public Integer dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return null;
		}
		else
		{
			return pqueue[--nItem];
		}
	}
	public Integer front()
	{
		return pqueue[nItem];//peek at minimum item
	}
	
	
}
public class PriorityQueue {
//priority queue insert the highest (smallest) priority element at front so that it can be removed first
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length");
		 int size = in.nextInt();
		PQueue queueObj=new PQueue(size);
		boolean flag=true;
		while(flag){
		
		 System.out.println("Enter choice number: ");
		 System.out.println("1) add element: ");
		 System.out.println("2) remove element: ");
		 System.out.println("3) Peek element: ");
		 System.out.println("4) Display: ");
		 int N = in.nextInt();
		 Integer num;
		 switch(N)
		 {
		 	case 1: System.out.println("Enter number to push: ");
		 			num=in.nextInt();
		 			queueObj.enqueue(num);
		 			break;
		 	case 2: System.out.println(queueObj.dequeue());
		 			break;
		 	case 3: System.out.println(queueObj.front());
		 			break;
		 	case 4: queueObj.display();
		 }
		 System.out.println("continue....press y/n ");
		 String ch = in.next();
		 if (ch.equals("n")) flag=false;
		 else {continue;}
	     in.close();
		}


	}

}
