package LinkedList;
/*You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. The second pointer however CAN point to any node in the list and not just the previous node. 
 * Now write a program in O(n) time to duplicate this list. That is, write a program which will create a copy of this list.*/
//not my work
import java.util.HashMap;
import java.util.Map;

class ListNode
{
 int data;
 ListNode next, random;//Next and random reference

 public ListNode(int data)
 {
     this.data = data;
     this.next = this.random = null;
 }
}

class LinkedList
{
	ListNode head;

 public LinkedList(ListNode head)
 {
     this.head = head;
 }

 public void push(int data)
 {
	 ListNode node = new ListNode(data);
     node.next = this.head;
     this.head = node;
 }

 // Method to print the list.
 void print()
 {
	 ListNode temp = head;
     while (temp != null)
     {
    	 ListNode random = temp.random;
         int randomData = (random != null)? random.data: -1;
         System.out.println("Data " + temp.data +
                            ", Random data "+ randomData);
         temp = temp.next;
     }
 }
 
//method which returns head reference of cloned linked list.
 public LinkedList clone()
 {
     // Initialize two references, one with original list's head.
	 ListNode origCurr = this.head, cloneCurr = null;

     // Hash map which contains node to node mapping of original and clone linked list.
     Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();

     // Traverse the original list and make a copy of that in the clone linked list.
     while (origCurr != null)
     {
         cloneCurr = new ListNode(origCurr.data);
         map.put(origCurr, cloneCurr);
         origCurr = origCurr.next;
     }

     // Adjusting the original list reference again.
     origCurr = this.head;

     // Traversal of original list again to adjust the next and random references of clone list using hash map.
     while (origCurr != null)
     {
         cloneCurr = map.get(origCurr);
         cloneCurr.next = map.get(origCurr.next);
         cloneCurr.random = map.get(origCurr.random);
         origCurr = origCurr.next;
     }

     //return the head reference of the clone list.
     return new LinkedList(map.get(this.head));
 }
}

public class CloneALinkListWithArbitPtr {
	  public static void main(String[] args)
    {
        // Pushing data in the linked list.
        LinkedList list = new LinkedList(new ListNode(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
 
        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
            list.head.next.next.next;
        list.head.next.next.random =
            list.head.next.next.next.next;
        list.head.next.next.next.random =
            list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
            list.head.next;
 
        // Making a clone of the original linked list.
        LinkedList clone = list.clone();
 
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();
    }

}