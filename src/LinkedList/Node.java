package LinkedList;

public class Node {
		int data;
		Node next;
		Node random;//this ptr is required for cloning the link list 
		Node(int d){
	        data=d;
	        next=null;
	        random=null;
	       }
		int getData()
		{
			return this.data;
		}
}
