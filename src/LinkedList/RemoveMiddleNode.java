/*Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.*/
package LinkedList;

import java.util.Scanner;

public class RemoveMiddleNode {
	
	//function to remove middle node 
	static boolean deleteMiddleNode(Node n)
	{
		if(n ==null || n.next==null) return false;
		Node temp = n.next;
		n.data=temp.data;
		n.next=temp.next;
		temp = null;
		
		return true;
		
	}
	
	//function to find middle node
	static Node findMiddleNode(Node head)
	{
		Node prev=head;
		Node cn=head;
		int i=0;
		while(cn.next!=null)
		{
			if(i==0) 
			{
				cn=cn.next;//increment only one pointer
				i++;
			}
			else if(i==1)
			{//increment both pointers
				cn=cn.next;
				prev=prev.next;
				i=0;//set i=0 again to increment current pointer twice
			}
		}
		return prev;//prev points to middle node
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
	        Node result1=findMiddleNode(head);
	        System.out.println(result1.data+ "enter node to delete");
	        
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
