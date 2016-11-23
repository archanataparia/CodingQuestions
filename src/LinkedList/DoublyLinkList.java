package LinkedList;
import java.util.*;

class dNode{
		int data;
		dNode next;
		dNode prev;
		dNode(int d){
	        data=d;
	        next=null;
	        prev=null;
	    }	
	}
public class DoublyLinkList {
	public static  dNode insert(dNode head,int data,int pos)
	{
		dNode newNode=new dNode(data);
		if(head==null)
		{
			head=newNode;
			return head;
		}
		if(pos==1)//inserting at beginning
		{
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			return head;
		}
		dNode cn=head;
		int k=1;
		while(cn.next!=null && k<pos-1)
		{
			cn=cn.next;
			k++;
		}
		if(k!=pos) System.out.println("position not found");
		newNode.next=cn.next;
		newNode.prev=cn;
		if(cn.next!=null) cn.next.prev=newNode;
		cn.next=newNode;
		return head;
	}
	
	public static boolean isEmpty(dNode head)
	{return (head==null);}
	
	
	public static  dNode remove(dNode head,int data)
	{
		dNode cn=head;
		if (cn.data==data){return head.next;}
		while(cn.next!=null){
			if(cn.next.data==data) 
			{
				cn.next= cn.next.next;
				cn.next.next.prev=cn;
			}
			cn=cn.next;
		}
		
		return head;
	}
    public static void display(dNode head)
    {
          dNode start=head;
          while(start!=null)
          {
              System.out.print(start.data+" ");
              start=start.next;
          }
    }
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
         dNode head=null;
         int T=sc.nextInt();
         while(T-->0){
             int ele=sc.nextInt();
             int pos=sc.nextInt();
             head=insert(head,ele,pos);
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
