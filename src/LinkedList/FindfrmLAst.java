/*Implement an algorithm to find the kth to last element of a singly linked list.*/
package LinkedList;

import java.util.Scanner;

public class FindfrmLAst {
	
	/*static int findElementfrmLastRecursion(Node head,int k)
	{
		if(head ==null) return 0;
		int count=0;
		findElementfrmLastRecursion(head.next,k);//recursive call
		count++;
		if(count==k)
		{
			System.out.println(head.data);
		}

		return count;
	}*/
	
	static void findElementItrative1(Node head, int k)
	{
		//with two scan O(n)time and O(n)space
		int count=0;
		Node temp=head;
		//count the number of nodes
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		
		if(k>count)return;//check input validity 
		temp=head;//reset temp
		//print the count-k+1 node from starting as that will be kth node from last
		for(int i=1;i<count-k+1;i++)
		{
			temp=temp.next;
		}
		System.out.println("node is "+temp.data);
		
		
	}
	static Node findElementItrative2(Node head, int k)
	{
		//with one scan O(n)time and O(1)space
		 if(k<0) return null;
		Node pTemp=head;
		Node pNthNode = head;
		for(int i=0;i<k;i++)
		{	
			if(pTemp!=null)
				pTemp=pTemp.next;
		}
		//pNthNode starts moving only after pTemp made k moves
		while(pTemp!=null)
		{
			if(pNthNode==null) 
				pNthNode=head;
			else
				pNthNode=pNthNode.next;
			pTemp=pTemp.next;//now both moves fw
		}
		//so when ptemp will reach to end pnthNode will point to Nth Node
		if(pNthNode!=null) return pNthNode;
		else
			return null;
				
	
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
        
		Node temp = findElementItrative2(head,k);
		System.out.println("method2 "+temp.data);
		findElementItrative1(head,k);
		sc.close();
		

	}
}
