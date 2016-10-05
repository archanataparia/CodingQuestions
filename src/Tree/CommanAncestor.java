package Tree;

import java.util.HashMap;
import java.util.Stack;
//need work
class BTreeNode
{
	public String name;
	public BTreeNode left,right;
	public BTreeNode(String name)
	{
		this.name=name;
		left=null;
		right=null;
	}
	
	public void dispalyNode()
	{
		 //System.out.println("{");
		 System.out.println("{"+name+"}");
		 //System.out.print("}");
	}
	public String getName()
	{
		return name;
	}
}//end  BTreeNode class

public class CommanAncestor {
	BTreeNode root;
	public CommanAncestor()
	{
		root=null;
	}
	public void createTree(String s)
	{
		//BTreeNode newNode=new BTreeNode(s);
		root=insert(root, s);
	}
	
	private BTreeNode insert(BTreeNode current, String s) {
		if(current==null)
		{
			current=new BTreeNode(s);
			return current;
		}
		if(!s.equalsIgnoreCase(current.name)||(current.left==null))
		{
			current.left=insert(current.left,s);
			return current;
		}
		if(!s.equalsIgnoreCase(current.name)||(current.right==null))
		{
			current.right=insert(current.right,s);
			return current;
		}
		
		return null;
	}
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(".................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<nBlanks; j++)
			System.out.print(" ");
			while(globalStack.isEmpty()==false)
			{
			BTreeNode temp = (BTreeNode)globalStack.pop();
			if(temp != null)
			{
			System.out.print(temp.name);
			localStack.push(temp.left);
			localStack.push(temp.right);
			if(temp.left != null ||
			temp.right!= null)
			isRowEmpty = false;
			}
			else
			{
			System.out.print("---");
			localStack.push(null);
			localStack.push(null);
			}
			for(int j=0; j<nBlanks*2-2; j++)
			System.out.print(" ");
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
			} // end while isRowEmpty is false
			System.out.println("----------------------------");
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommanAncestor tree = new CommanAncestor();
		
		 String s="Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Bob,Katie";
		    
		   String[] sarr = s.split(",");
		   String temp1=null,temp2=null;
	    for(int i=0;i<sarr.length-2;i++)
	    {
	    	
	    	 String[] temp=new String[2];
	    	 if(sarr[i].contains("->")) 
	    	 {
	    		 temp=sarr[i].split("->");
	    		 tree.createTree(temp[0]);
	    		 tree.createTree(temp[1]);
	    	 }
	    }
	    tree.displayTree();
	    temp1=sarr[sarr.length-1];
	    temp2=sarr[sarr.length-2];
	    }

	}

/*public static Node LCA(Node root, Node a, Node b) {
		   if (root == null) {
		       return null;
		   }

		   // If the root is one of a or b, then it is the LCA
		   if (root == a || root == b) {
		       return root;
		   }

		   Node left = LCA(root.left, a, b);
		   Node right = LCA(root.right, a, b);

		   // If both nodes lie in left or right then their LCA is in left or right,
		   // Otherwise root is their LCA
		   if (left != null && right != null) {
		      return root;
		   }

		   return (left != null) ? left : right; 
		}
*/
