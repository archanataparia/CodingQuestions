package Tree;

import java.util.Scanner;

public class NextSuccessor {

	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);

		//display tree
		tree.displayTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value of node to find successor ");
		int data=sc.nextInt();
		NextSuccessor ns=new NextSuccessor();
		Node output=ns.getSuccessor(tree.find(data));
		System.out.println("Successor is "+output.data);
	}
	/*Use parent pointer 
	 * The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.
	1) If right subtree of node is not NULL, then succ lies in right subtree. 
	2) If right sbtree of node is NULL, then succ is one of the ancestors.*/
	public Node getSuccessor(Node parentNode)
	{
		if(parentNode==null) return null;
		
		//return leftmost node of right subtree - cond1
		if(parentNode.right!=null) 
		{
			return leftMostNode(parentNode.right);
		}
		else
		/*cond2-Travel up using the parent pointer until you see a node which is left 
		 * child of it’s parent. The parent of such a node is the succ*/
		{
			Node p=parentNode.parent;
			Node temp=parentNode;
			while(p!=null && p.left!=temp)//go up
			{
				temp=p;
				p=p.parent;
			}
			return p;
		}
	}
	private Node leftMostNode(Node temp) {
		if(temp==null) return null;
		while(temp.left!=null)
		{
			temp=temp.left;
		}
		return temp;
	}

}
