package Queue;
/*
//need to finish
class Node
{
	Integer data;
	Node next;
	Node(Integer data)
	{
		this.data = data;
		next=null;
	}
}
class QueueLink
{
	public Node push(Node top,Integer num)
	{	//inserFirst implementation because insertLast is O(n) but at first its O(1)
		//creating a new node
		Node newNode=new Node(num);
		
		newNode.next=top;
		top=newNode;
		return top;	
	}
	
	public Node pop(Node top)
	{
		//deleteFirst implementation because insertLast is O(n) but at first its O(1)
		
		if(top == null) System.out.print("Link list is empty");
		System.out.println("element poped: "+top.data);
		top = top.next;
		return top;	
	}
	public void display(Node top)
	{
		Node travel=top;
		while(travel!=null){
			System.out.print(" "+ travel.data);
			travel=travel.next;
			}
	}
	
	
	public void peek(Node top)
	{
		//Visit Top of stack
		if(top == null) System.out.print("Link list is empty");
		System.out.println("element on top is: "+top.data);
	}
	
}
public class LinkListImplementationOfQueue {

	public static void main(String[] args) {
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

}*/
