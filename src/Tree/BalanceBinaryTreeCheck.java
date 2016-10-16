package Tree;

import java.util.Scanner;

/*Implement a function to check if a binary tree is balanced. For the purposes of this
question, a balanced tree is defined to be a tree such that the heights of the two
subtrees of any node never differ by more than one*/
public class BalanceBinaryTreeCheck {

	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		//display tree
		tree.displayTree();
		//check tree is balanced or not
		
		boolean result=checkBalanceTree(tree.root);
		System.out.println("Tree is balanced "+result);
	}

	private static boolean checkBalanceTree(Node root) {
		int height;
		height=checkHeight(root);
		if (height==-1)
		return false;
		else return true;
	}

	private static int checkHeight(Node root) {
		int lHeight,rHeight,hDiff;
		
		if(root==null) return 0;//height is 0
		
		lHeight=checkHeight(root.left);//check left subtree
		if(lHeight ==-1) return -1;//not balanced
		
		rHeight=checkHeight(root.right);//check right subtree
		if(rHeight ==-1) return -1;//not balanced
		
		hDiff=lHeight-rHeight;
		if(Math.abs(hDiff)>1)
		return -1;
		else
			return(Math.max(lHeight, rHeight)+1);//return height
	}


}
