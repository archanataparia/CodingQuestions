/*Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.*/
package LinkedList;

import java.util.Scanner;

public class RemoveMiddleNode {
	
	static boolean deleteMiddleNode(Node n)
	{
		if(n ==null || n.next==null) return false;
		Node temp = n.next;
		n.data=temp.data;
		n.next=temp.next;
		temp = null;
		
		return true;
		
	}

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
	        Node head=null;
	        int T=sc.nextInt();
	        while(T-->0){
	            int ele=sc.nextInt();
	            head=LinkList.insertFirst(head,ele);
	            //display(head);
	        }
	      
	        LinkList.display(head);
	       int k =sc.nextInt();
	        Node n=head;
	        while(n.data!=k) {
	        	n=n.next;}
	        boolean result=deleteMiddleNode(n);
	        System.out.println(result);
	        LinkList.display(head);
	        sc.close();

	}

}
