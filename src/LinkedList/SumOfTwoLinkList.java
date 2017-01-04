package LinkedList;
//imp
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
    	   Node temp=addLists(head1,head2);
           LinkList.display(temp);
           System.out.println();
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
		  
		  while(head1!=null || head2!=null)  
		  {  
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
		  
		  if(sum>9)//two digits sum
		   {
			  carry=sum/10;  
			  sum=sum%10;
		   } 
		     
		   if(newHead==null)  // Check if it first node for the result
		   {   
		    tempNodeForIteration = new Node(sum);  
		    newHead=tempNodeForIteration;  
		   }  
		   else  
		   {  
		    tempNodeForIteration.next=new Node(sum);  
		    tempNodeForIteration=tempNodeForIteration.next;  
		   }  
		  } //end of while loop 

		  if(carry!=0)//check for the last carry to add in the list 
		    tempNodeForIteration.next=new Node(carry);
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
	
	//recursive approach
	private static Node addLists(Node first, Node second) {    
	    return addRecursive(first, second, 0);
	 }
	
	private static Node addRecursive(Node first, Node second, int carry) {
	    if (first == null && second == null && carry == 0) {
	        return null;
	    }
	    else if (first == null && second == null && carry != 0) {
	        return new Node(carry);
	    }
	    int firstData = first == null ? 0 : first.data;
	    int secondData = second == null ? 0 : second.data;
	    Node sum = new Node ((firstData + secondData + carry) % 10);
	    int newCarry = (firstData + secondData + carry) / 10;
	    first = first != null ? first.next : null;
	    second = second != null ? second.next : null;
	    sum.next = addRecursive(first , second, newCarry);
	    return sum;
	}

}
 