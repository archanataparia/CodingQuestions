package LinkedList;

import java.util.Scanner;
//code to reverse Singly Linked List by iterating through it only once

public class ReverseLinkList {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
	        Node head=null;
	        int T=sc.nextInt();
	        while(T-->0){
	            int ele=sc.nextInt();
	            head=LinkList.insertLast(head,ele);
	        }
	    
	        System.out.println("list before reverse");
	        LinkList.display(head);
	        
	       /* Node result=reverseList(head);
	        System.out.println("list after reverse");
	        LinkList.display(result);*/
	        System.out.println("Linlist after partial reverse");
	        Node result=reverseListParts(head,3);
	        LinkList.display(result);
			sc.close();

	}
//method to reverse a link list
	public static Node reverseList(Node head) {
		Node currentNode = head;
		Node prevNode = null;
		Node nextNode = null;
		while (currentNode!=null)
		{
			nextNode = currentNode.next;
			currentNode.next=prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head= prevNode;
		
		return head;
	
}

/*Reverse Linked list in parts iteratively. 
ex 1->2->3->4->5->6->7->8 and if 'parts' is 3. 
o/p = 3->2->1->6->5->4->8->7.*/
	public static Node reverseListParts(Node head,int count) {
		int c=count;
		Node currentNode = head;
		Node prevNode = null;
		Node nextNode = null;
		while (currentNode!=null && c>0 )//reverse list in parts
		{
			nextNode = currentNode.next;
			currentNode.next=prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
			c--;
		}
		if(currentNode!=null)//recursive call to make nextpart reverse
				head.next=reverseListParts(nextNode,count);
		return prevNode;		
	}
}
/*Recursive approach
 * 
 public static Node reverseR(Node node) {
    if (node == null || node.next == null) {
        return node;
    }

    Node next = node.next;
    node.next = null;

    Node remaining = reverseR(next);
    next.next = node;
    return remaining;
}

 *or
 *
 *Node reverse(Node head) {
  // if head is null or only one node, it's reverse of itself.
  if ( (head==null) || (head.next == null) ) return head;

  // reverse the sub-list leaving the head node.
  Node reverse = reverse(head.next);

  // head.next still points to the last element of reversed sub-list.
  // so move the head to end.
  head.next.next = head;

  // point last node to nil, (get rid of cycles)
  head.next = null;
  return reverse;
}*/
 