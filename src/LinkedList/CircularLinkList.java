package LinkedList;
import java.util.*;

public class CircularLinkList {
	public static  Node insertBegin(Node head,int data)
	{
		Node newNode=new Node(data);
		Node cn=head;
		while (cn.next!=head)
		{
			cn=cn.next;
		}
		newNode.next=newNode;//newnode pointing to itself
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			newNode.next=head;
			cn.next=newNode;
			head=newNode;
		}
		
		return head;
	}
	
	public static boolean isEmpty(dNode head)
	{return (head==null);}
	
	
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
          do 
          {
              System.out.print(start.data+" ");
              start=start.next;
          }while(start!=head);
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Node head=null;
       int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insertBegin(head,ele);
            //display(head);
        }
       
        display(head);
        
        int T2=sc.nextInt();
        
        //head=remove(head,T2);
        //display(head);
    display(head);
        sc.close();

	}

}
