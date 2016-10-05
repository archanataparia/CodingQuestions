package Tree;

import java.util.Scanner;

//new node creation
class Node
{
	Integer data;
	Node left;
	Node right;
	Node(Integer data)
	{
		this.data=data;
		left=right=null;
	}
}

public class BineryTree {

	Node root;
	
	//in order traversal
	public void inOrder(Node root) {  
		  if(root !=  null) {  
		   inOrder(root.left);  
		   //Visit the node by Printing the node data    
		   System.out.printf("%d ",root.data);  
		   inOrder(root.right);  
		  }  
		 }  

	//create binary tree 
	public static Node createBinaryTree()
	{
		Node rootNode =new Node(40);  
		  Node node20=new Node(20);  
		  Node node10=new Node(10);  
		  Node node30=new Node(30);  
		  Node node60=new Node(60);  
		  Node node50=new Node(50);  
		  Node node70=new Node(70);  
		    
		  rootNode.left=node20;  
		  rootNode.right=node60;  
		    
		  node20.left=node10;  
		  node20.right=node30;  
		    
		  node60.left=node50;  
		  node60.right=node70;  
		    
		  return rootNode; 
	}
//------Determine tree is balanced or not (Method 1) with O(n2)-----
	//following function provide height of the tree
	public int getHeight(Node root)
	{
		if (root==null) return 0;//base condition
		else
		{
			return (Math.max(getHeight(root.left), getHeight(root.right)))+1;
		}
	}
	
	//following function verify tree is balanced or not
	public boolean isBalancetree(Node root)
	{
		if (root==null) return true;
		int heightDiff = getHeight(root.left)-getHeight(root.right);
		if(heightDiff>1) return false;
		else return isBalancetree(root.left) && isBalancetree(root.right);
	}
	
	//------Determine tree is balanced or not (Method 2) with O(n)-----
	public int checkHeight(Node root)
	{
		if (root==null) return 0;//base condition
		//check if left is balanced
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) return -1;//not balanced
		
		//check if right is balanced
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) return -1;//not balanced
		
		//check if current node is balanced
		int heightDiff = Math.abs(leftHeight-rightHeight);
		if (heightDiff == -1) return -1;//not balanced
		else
			return (Math.max(rightHeight, leftHeight))+1;
				
	}
	public boolean isBalancetree2(Node root)
	{
		if (checkHeight(root)==-1) return false;
		else return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BineryTree bt=new BineryTree();
       Node rootNode =createBinaryTree();
       
       bt.inOrder(rootNode);
       System.out.println(bt.isBalancetree(rootNode));
       System.out.println(bt.isBalancetree2(rootNode));
        sc.close();
	}

	

}
