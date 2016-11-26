package LinkedList;

import java.util.Scanner;
/* two linked list intersect at some point and become a single link list. 
 * both lists may have different length before merging point*/
public class IntersectTwoLinkList {
	 /*function to get the intersection point of two linked
	 lists head1 and head2 */
	class Result
	{
		public Node tail;
		public int size;
		Result(Node tail,int size)
		{
			this.tail=tail;
			this.size=size;
		}
	}
	 int findIntersection(Node head1,Node head2) {
	     Result r1 = getCountAndTail(head1);
	     Result r2 = getCountAndTail(head2);
	     int d;

	     //if different tails then no intersection
	     if(r1.tail!=r2.tail) return 0;
	     
	     if (r1.size > r2.size) {
	         d = r1.size - r2.size;
	         return _getIntesectionNode(d, head1, head2);
	     } else {
	         d = r2.size - r1.size;
	         return _getIntesectionNode(d, head2, head1);
	     }
	 }


	/* function to get the intersection point of two linked lists head1 and head2 where head1 
	 * has d more nodes than head2 */
	int _getIntesectionNode(int d, Node node1, Node node2) {
	 int i;
	 Node current1 = node1;
	 Node current2 = node2;
	 for (i = 0; i < d; i++) {
	     if (current1 == null) {
	         return -1;
	     }
	     current1 = current1.next;
	 }
	 while (current1 != null && current2 != null) {
	     if (current1.data == current2.data) {
	         return current1.data;
	     }
	     current1 = current1.next;
	     current2 = current2.next;
	 }

	 return -1;
	}

	/*Takes head pointer of the linked list and returns the count of nodes in the list */
	Result getCountAndTail(Node node) {
	 Node current = node;
	 int count = 0;

	 while (current != null) {
	     count++;
	     current = current.next;
	 }

	 return new Result(current,count);
	}
	public static void main(String[] args) {
		 
		 IntersectTwoLinkList list = new IntersectTwoLinkList();
		 
	     // creating first linked list
		 Node head1=null;
		 head1=LinkList.insertLast(head1,3);
		 head1=LinkList.insertLast(head1,6);
		 head1=LinkList.insertLast(head1,15);
		 head1=LinkList.insertLast(head1,15);
		 head1=LinkList.insertLast(head1,30);
		
	     // creating second linked list
		 Node head2=null;
		 head2=LinkList.insertLast(head2,10);
		 head2=LinkList.insertLast(head2,15);
		 head2=LinkList.insertLast(head2,30);
	     System.out.println("The node of intersection is " + list.findIntersection(head1,head2));
	}

	/*private static Node findIntersectingNode(Node head, Node head2) {
		int l1=0,l2=0,diff=0;
		Node h1=head;
		Node h2=head2;
		
		//find length of both lists
		while(h1!=null)
		{
			h1=h1.next;
			l1++;
		}
		while(h2!=null)
		{
			h2=h2.next;
			l2++;
		}
		
		//take the difference
		if(l1<l2)
		{
			h1=head2;
			h2=head;
			diff=l2-l1;
		}
		else
		{
			h1=head;
			h2=head2;
			diff=l1-l2;
		}
		
		//make diff steps in longer list
		for(int i=0;i<diff;i++)
			h1=h1.next;
		//steps in both list till match
		while(h1!=null && h2!=null)
		{
			if(h1.equals(h2)) return h1;
			h1=h1.next;
			h2=h2.next;
		}
			
		return null;
	}*/

}
