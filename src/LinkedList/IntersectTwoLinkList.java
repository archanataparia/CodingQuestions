package LinkedList;

import java.util.Scanner;



/* two linked list intersect at some point and become a signle link list. 
 * both lists may have different length before merging point*/
public class IntersectTwoLinkList {
	static Node head1, head2;

	 static class Node {

	     int data;
	     Node next;

	     Node(int d) {
	         data = d;
	         next = null;
	     }
	 }
	 /*function to get the intersection point of two linked
	 lists head1 and head2 */
	 int getNode() {
	     int c1 = getCount(head1);
	     int c2 = getCount(head2);
	     int d;

	     if (c1 > c2) {
	         d = c1 - c2;
	         return _getIntesectionNode(d, head1, head2);
	     } else {
	         d = c2 - c1;
	         return _getIntesectionNode(d, head2, head1);
	     }
	 }


	/* function to get the intersection point of two linked
	lists head1 and head2 where head1 has d more nodes than
	head2 */
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

	/*Takes head pointer of the linked list and
	returns the count of nodes in the list */
	int getCount(Node node) {
	 Node current = node;
	 int count = 0;

	 while (current != null) {
	     count++;
	     current = current.next;
	 }

	 return count;
	}
	public static void main(String[] args) {
		 
		 IntersectTwoLinkList list = new IntersectTwoLinkList();
		 
	     // creating first linked list
	     list.head1 = new Node(3);
	     list.head1.next = new Node(6);
	     list.head1.next.next = new Node(15);
	     list.head1.next.next.next = new Node(15);
	     list.head1.next.next.next.next = new Node(30);

	     // creating second linked list
	     list.head2 = new Node(10);
	     list.head2.next = new Node(15);
	     list.head2.next.next = new Node(30);
	     System.out.println("The node of intersection is " + list.getNode());
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
