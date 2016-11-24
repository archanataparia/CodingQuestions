package LinkedList;

import java.util.Hashtable;
import java.util.Scanner;

//check whether the given linked list is either null-terminated or ends in a cycle. 
public class FindCycleInLinkList {

	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
	        Node head=null;
	        int T=sc.nextInt();
	        while(T-->0){
	            int ele=sc.nextInt();
	            head=LinkList.insertFirst(head,ele);
	        }
	        LinkList.display(head);
	        //create loop for testing
	        head.next.next.next.next=head;
	        
	        Boolean result = findLoop1(head);
			System.out.println("Result1 "+result);
			Boolean result2 = findLoop2(head);
			System.out.println("Result2 "+result2);
			
			sc.close();
			

	}
	
	// Use hash table to store address O(n)time and O(n)space
	private static Boolean findLoop1(Node head) {
		Hashtable<Node,Integer> ht=new Hashtable<Node,Integer>();
		if(head==null)return false;
		Node temp=head;
		//traverse through the link list
		while(temp!=null)
		{
			if(ht.containsKey(temp))
			{
				ht.put(temp, ht.get(temp)+1);
				return true;
			}
			else
				ht.put(temp, 1);
			temp=temp.next;
		}
		return false;
	}
	
	//Floyd cycle finding algorithm O(n)time and O(1)space
	private static Boolean findLoop2(Node head) {
		/*it uses 2 ptr moving at different speed to walk the link list. 
		 * Once they enter the loop they expected to meet. slow ptr moves 1 place and fast moves 2 place at a time
		 */
		if(head==null) return false;
		Node pSlow=head;
		Node pFast=head;
		while (pSlow.next!=null && pFast.next!=null && pFast.next.next!=null)
		{
			pSlow=pSlow.next;
			pFast=pFast.next.next;
			if(pSlow==pFast)return true;//a loop exists
		};
		return false;
	}

}
