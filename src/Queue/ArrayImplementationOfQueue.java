package Queue;

import java.util.Scanner;

class Queue
{
		private Integer queue[];
		private Integer front,rear;
		
		Queue(int size)
		{
			queue=new Integer[size];
			front =-1;
			rear=-1;
		}
		private boolean isFull() {
			return (rear == queue.length-1);
		}
		private boolean isEmpty() {
			return front ==-1;
			
		}
	public void display() {
			for(int i=0;i<queue.length;i++)
			{
				System.out.print(" " + queue[i]);
			}
		}
		
	public void enqueue(Integer num)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
		}
		else if(isEmpty())
		{
			front=rear=0;
			queue[rear]=num;
		}
		else
		{
			queue[++rear]=num;
		}
	}
	public Integer dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return null;
		}
		else if (front==rear)front=rear=-1;
		Integer num=queue[front++];
		return num;
		
	}
	public Integer front()
	{
		return queue[front];
	}
}

public class ArrayImplementationOfQueue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length");
		 int size = in.nextInt();
		Queue queueObj=new Queue(size);
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
