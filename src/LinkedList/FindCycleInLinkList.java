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
			Node result2 = findLoop2(head);
			System.out.println("Result2 "+result2.data);
			
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
	private static Node findLoop2(Node head) {
		/*it uses 2 ptr moving at different speed to walk the link list. 
		 * Once they enter the loop they expected to meet. slow ptr moves 1 place and fast moves 2 place at a time
		 */
		
		if(head==null) {return null;}
		Node pSlow=head;
		Node pFast=head;
		boolean loopExist1=false;
		boolean loopExist2=false;
		while (pSlow!=null && pFast!=null && pFast.next!=null)
		{
			pSlow=pSlow.next;
			pFast=pFast.next.next;
			if(pSlow==pFast)
			{
				loopExist1=true;
				loopExist2=true;
				break;//return true;
			}//a loop exists
			
		};
		//return false;//end of code if we are not returning starting point of cycle
		int counter=0;
		//if we are asked to calculate size of loop then we can extend this code
		if(loopExist1)
		{
			pFast=pFast.next;//coz both pr are equal now so keep slow ptr as it is and move fast ptr only until it comes back to slow ptr
			while(pSlow!=pFast)
			{
				pFast=pFast.next;
				counter++;
			}
			System.out.println("length of cycle is "+counter);
		}
		//if we need to return node where cycle started this code can be extended
		if(loopExist2)
		{
			pSlow=head;//reset slow ptr
			while(pSlow!=pFast)
			{
			 //move both ptr fast is moving in backward dir and slow is moving in fw dir and they will meet at start pt of cycle 	
				pSlow=pSlow.next;
				pFast=pFast.next;
			}
			return pSlow;
		}
		return null;	
	}

}
