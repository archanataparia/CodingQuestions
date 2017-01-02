package sortingNSearching;



public class MergeSortedLinkList {
	static Node head1, head2;

	 static class Node {

	     int data;
	     Node next;

	     Node(int d) {
	         data = d;
	         next = null;
	     }
	 }
	 public  void display(Node head)
	    { System.out.println("head "+head);
	          Node start=head;
	          while(start!=null)
	          {
	              System.out.print(start.data+" ");
	              start=start.next;
	          }
	    }
	public static void main(String[] args) {
		MergeSortedLinkList list = new MergeSortedLinkList();
		 
	     // creating first linked list
	     list.head1 = new Node(3);
	     list.head1.next = new Node(6);
	     list.head1.next.next = new Node(11);
	     list.head1.next.next.next = new Node(18);
	     list.head1.next.next.next.next = new Node(30);

	     // creating second linked list
	     list.head2 = new Node(10);
	     list.head2.next = new Node(15);
	     list.head2.next.next = new Node(35);
	     //Node result=list.mergeListIteration(list.head1,list.head2);
	     //list.display(result);
	    Node result2=list.mergeListRec(list.head1,list.head2);
	     list.display(result2);

	}
	private Node mergeListRec(Node head1, Node head2) {
		Node h1=head1;
		Node h2=head2;
		Node result=null;
		//base condition
		if(h1==null && h2== null) return null;
		if(h1==null)return h2;
		if(h2==null)return h1;
		
		if(h1.data<h2.data)
		{
			result=h1;
			result.next=mergeListRec(h1.next,h2);
		}
		else
		{
			result=h2;
			result.next=mergeListRec(h2.next,h1);
		}
		return result;
	}
	
	//this code need work
	private Node mergeListIteration(Node head1, Node head2) {
		Node h1=head1;
		Node h2=head2;
		Node n=new Node(0);
		
		Node head=n;
		
		if(h1==null && h2== null) return null;
		if(h1==null)return h2;
		if(h2==null)return h1;
		
		//compare two list
		while(h1!=null && h2!=null)
		{
			if(h1.data<=h2.data)
			{
				head.next=h1;
				h1=h1.next;
			}
			else
			{
				head.next=h2;
				h2=h2.next;
			}
			head=head.next;
		}
		//add remaining content
		if(h1!=null)
			head.next=h1;
		else
			head.next=h2;
		return head;
	}
	

}
