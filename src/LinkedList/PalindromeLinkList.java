package LinkedList;

import java.util.Scanner;

public class PalindromeLinkList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=LinkList.insertLast(head,ele);
        }
        LinkList.display(head);
        Boolean result=isPalindrome(head);
        if(result)System.out.println("palindrome");
        else
        	System.out.println("not palindrome ");
	}

	private static Boolean isPalindrome(Node head) {
		 Node rev=reverseAndClone(head);
		 LinkList.display(rev);
		return isEqual(head,rev);
	}

	private static boolean isEqual(Node head, Node rev) {
		while(head!=null && rev!=null)
		{
			if(head.data!=rev.data)return false;
			head=head.next;
			rev=rev.next;
		}
		boolean output= (head==null)?true:false;
		System.out.println(output);
		return output;
	}

	private static Node reverseAndClone(Node head) {
		Node current=head;
		Node prev = null;
		Node next = null;
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}

}
