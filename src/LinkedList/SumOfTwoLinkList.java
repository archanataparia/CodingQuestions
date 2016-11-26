package LinkedList;

import java.util.Scanner;
//Given two numbers represented by two linked lists, write a function that returns sum list. 
public class SumOfTwoLinkList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Node head1=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head1=LinkList.insertLast(head1,ele);
        }
        System.out.println("list1 ");
        LinkList.display(head1);
        Node head2=null;
        int T2=sc.nextInt();
        while(T2-->0){
            int ele2=sc.nextInt();
            head2=LinkList.insertLast(head2,ele2);
        }
    	   head1=reverseList(head1);
    	   head2=reverseList(head2);  
  Node result=sumOfTwoLinkList(head1,head2);
  result=reverseList(result);
        LinkList.display(result);
	}

	//main function that add two link list
	private static Node sumOfTwoLinkList(Node head1, Node head2) {
	
		int carry =0;  
	    
		  Node newHead = null;  
		  Node tempNodeForIteration=null;  
		  int sum=0;  
		  
		  int firstIter=0;  
		  while(head1!=null || head2!=null)  
		  {  
		   firstIter++;  
		   sum=carry;  
		   if(head1!=null)  
		   {  
		    sum=sum+head1.data;  
		    head1=head1.next;  
		   }  
		  
		   if(head2!=null)  
		   {  
		    sum=sum+head2.data;  
		    head2=head2.next;  
		   }  
		  
		  
		   carry=sum/10;  
		   sum=sum%10;  
		   // Check if it first node for the result  
		   if(firstIter==1)  
		   {   
		    tempNodeForIteration = new Node(sum);  
		    newHead=tempNodeForIteration;  
		   }  
		   else  
		   {  
		    Node tempSumNode=new Node(sum);  
		    tempNodeForIteration.next=tempSumNode;  
		    tempNodeForIteration=tempNodeForIteration.next;  
		   }  
		     
		  }  
		  if(carry!=0)  
		  {  
		   Node tempNode=new Node(carry);  
		   tempNodeForIteration.next=tempNode;  
		  }  
		  return newHead;  
	}

	private static Node reverseList(Node head)
	{
		if(head==null || head.next==null) return head;//base condition
		
		Node reverse=reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return reverse;
	}

}
