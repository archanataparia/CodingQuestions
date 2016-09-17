/*Implement an algorithm to find the kth to last element of a singly linked list.*/
package LinkedList;

import java.util.Scanner;

public class FindfrmLAst {
	
	static int findElementfrmLastRecursion(Node head,int k)
	{
		if(head ==null) return 0;
		int count=0;
		count = findElementfrmLastRecursion(head.next,k)+1;//recursive call
		if(count==k)
		{
			System.out.println(head.data);
		}

		return count;
	}
	
	static Node findElementItrative(Node head, int k)
	{
		if(k<0) return null;
		Node p1=head;
		Node p2 = head;
		for(int i =0;i<k-1;i++)
		{	if(p2==null) return null;
			p2=p2.next;
		}
		if(p2==null) return null;
		while(p2!=null)
		{
			p2=p2.next;
			p1=p1.next;
		}
		return p1;
		
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
        System.out.println("enter numebr");int k =sc.nextInt();
        LinkList.display(head);
        
		int data = findElementfrmLastRecursion(head,k);
		System.out.println(data);
		Node head1 = findElementItrative(head,k);
		System.out.println(head1.data);
		//LinkList.display(head);
		sc.close();
		

	}
}
