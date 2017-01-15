package Tree;
//imp
import java.util.Scanner;

/*Imp/emen t a function to check if a binary tree is a binary search tree*/
public class CheckBST {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BineryTree bt=new BineryTree();
		Node broot=bt.createBinaryTree();
		CheckBST check=new CheckBST();
		boolean result1,result2;
		result1=check.checkBSTMethod1(broot);
		result2=check.checkBSTMethod2(broot);
		System.out.println("result1 "+result1+" result2 "+result2);
	}

//Approach to check BST using In-order traversal
	static int last=Integer.MIN_VALUE;// keep track of last printed node
	public boolean checkBSTMethod1(Node root) 
	{
		if(root==null) return true;
		
		//check left
		if(!checkBSTMethod1(root.left)) return false;
		//check current
		if(root.data<=last) return false;
		last=root.data;
		//check right
		if(!checkBSTMethod1(root.right)) return false;
		return true;
	}
	
	//Approach to check BST using BST defination left<=current<right
	public boolean checkBSTMethod2(Node root) {
		return checkBSTMethod2(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBSTMethod2(Node root, int minValue, int maxValue) {
		
		if(root==null) return true;
		if(root.data>maxValue||root.data<minValue) return false;
		if((!checkBSTMethod2(root.left,minValue,root.data))||
				(!checkBSTMethod2(root.right,root.data,maxValue)))
			return false;
		return true;
	}

}
