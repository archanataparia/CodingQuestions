package Stack;

import java.util.Scanner;
import java.util.Stack;
public class ReverseLinkListWithStack {
	
	//not right need rework

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 Node head=null;
		 Stack<Integer> stack=new Stack<Integer>();
		 StackLink sl=new StackLink();
	        int T=sc.nextInt();
	        while(T-->0){
	            Integer ele=sc.nextInt();
	            //stack.push(ele);
	           
	           head=sl.push(head, ele);
	        }
	        System.out.println("list before reverse");
	        sl.display(head);
	        
	        head=reverseList(head);
	        System.out.println("list after reverse");
	        sl.display(head);
			sc.close();

	}

	public  static Node reverseList(Node top) {
		
		StackLink stack=new StackLink(); 
		Node travel=top;
		if(top==null) return null;
		else
		{
			while(travel!=null)
			{
				stack.push(travel, travel.data);
				travel=travel.next;
			}
		}
		Node temp=travel;
		//top=travel;
		while(top!=null)
		{
			travel.next=stack.pop(top);
			travel=travel.next;
			
		}
		
		return null;
	}

}
