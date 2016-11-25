package LinkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertNodeInSortedLinkList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        //Node head=null;
       /* LinkedList<Integer> list=new LinkedList<Integer>();
        int T=sc.nextInt();
        while(T-->0){
        	list.add(sc.nextInt());
        }
        Collections.sort(list);//sort the list
        //display list
        for(int i=0;i<list.size();i++)
        {
        	System.out.print(list.get(i)+" ");
        }*/
		Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=LinkList.insertLast(head,ele);
        }
        LinkList.display(head);
        int newData=sc.nextInt();
        Node head1=insertInSortedList(head,newData);
        LinkList.display(head1);
        
        
     }

	private static Node insertInSortedList(Node head, int data) 
	{
		Node newNode=new Node(data);
		Node prev=null;
		Node current=head;
		
		if(head ==null) return newNode;
		
		//traverse the list until you find big one
		while(current!=null && data>current.data)
		{
			prev=current;
			current=current.next;
		}
		//insert the new node before big one
		newNode.next=current;
		prev.next=newNode;
		
		return head;
		
	}

}
