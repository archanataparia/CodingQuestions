package LinkedList;


import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class LinkList {
	public static  Node insertFirst(Node head,int data)
	{
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
		return head;
	}
	
	public static boolean isEmpty(Node head)
	{return (head==null);}
	
	public static  Node insertLast(Node head,int data)
	{	Node newNode=new Node(data);
		if(head ==null) 
		{newNode.next=head;
		head=newNode;
		return head;}
		
		Node cn=head;
		while(cn.next!=null)
		{
			cn = cn.next;
		}
		cn.next=newNode;
		return head;
	}
	public static  Node remove(Node head,int data)
	{
		Node cn=head;
		if (cn.data==data){return head.next;}
		while(cn.next!=null){
			if(cn.next.data==data) 
			{
				cn.next= cn.next.next;
			}
			cn=cn.next;
		}
		
		return head;
	}
    public static void display(Node head)
    {
          Node start=head;
          while(start!=null)
          {
              System.out.print(start.data+" ");
              start=start.next;
          }
    }
    public static void main(String args[])
    {
          Scanner sc=new Scanner(System.in);
          Node head=null;
          int T=sc.nextInt();
          while(T-->0){
              int ele=sc.nextInt();
              head=insertFirst(head,ele);
              //display(head);
          }
          display(head);
          int T1=sc.nextInt();
          while(T1-->0){
              int ele=sc.nextInt();
              head=insertLast(head,ele);
              //display(head);
          }
          display(head);
          int T2=sc.nextInt();
  
              head=remove(head,T2);
              //display(head);
          display(head);
          sc.close();

   }
}
