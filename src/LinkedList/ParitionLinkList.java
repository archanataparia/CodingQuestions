/*Write code to partition a linked list around a value x, such that all nodes less than x
come before all nodes greater than or equal to x.*/
package LinkedList;
import java.util.*;
public class ParitionLinkList {
	
	static Node partitionList(Node head, int k)
	{
		Node travel = head;
		Node list1=null;
		Node list2=null;
		
		if(head==null) return null;
		while(travel!=null)
		{	Node next=travel.next;//need to save next value
			if(travel.data >= k)
			{ 
				//insert node into start of list2
				travel.next=list2;
				list2=travel;
			}
			else
			{
				//insert node into start of list1
				travel.next=list1;
				list1=travel;
			}
			travel=next;	
		}
		if(list1 == null) return list2;
		else 
		{
			//find list1 end and merge both lists
			travel = list1;
			while(travel.next!=null) travel=travel.next;
			travel.next=list2;
		}
		
		return list1;
		
	}
	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
	        Node head=null;
	        int T=sc.nextInt();
	        while(T-->0){
	            int ele=sc.nextInt();
	            head=LinkList.insertLast(head,ele);
	        }
	        LinkList.display(head);
	        System.out.println("enter x");
	        int k =sc.nextInt();
	        Node result=partitionList(head,k);
	        System.out.println("final list");
	        LinkList.display(result);
			sc.close();

	}

}
