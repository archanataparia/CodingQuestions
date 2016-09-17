package LinkedList;

import java.util.*;

/*2.1 Write code to remove duplicates from an unsorted linked list.FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?*/

public class RemoveDuplicates {

		static Node removeDuplicate(Node head){
			Hashtable ht = new Hashtable();
			Node cn = head;
			Node pn = null;
			while(cn!=null){
				if(!ht.containsKey(cn.data)){
					ht.put(cn.data, true);
					pn=cn;
				}
				else
				{
					pn.next=cn.next;
					
				}
				cn= cn.next;
			}
			return head;
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
         System.out.println("after removal of duplicate");
		head = removeDuplicate(head);
		
		LinkList.display(head);
		

	}

}
