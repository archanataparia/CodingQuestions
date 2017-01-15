package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*find the kth smallest element in BST*/
public class KthSmallestElementInBST {

	public static void main(String[] args) {
		KthSmallestElementInBST obj = new KthSmallestElementInBST();
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		tree.displayTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter kth number ");
		int k=sc.nextInt();
		int result=obj.kthSmallestElement(tree.root,k);
		System.out.println("element found "+result);
	}

	private int kthSmallestElement(Node root, int k) {
		if(root==null) return 0;
		//perform inorder traversal
		Stack<Node> stack=new Stack<Node>();
		while(root!=null)//go to extreme left
		{
			stack.push(root);
			root=root.left;
		}
		Node temp;
	//create a list to store inorder traversal
		List<Integer> list=new ArrayList<Integer>();
		
		while(!stack.isEmpty())
		{
			temp=stack.pop();
			list.add(temp.data);
			if(temp.right!=null)
			{
				temp=temp.right;
				while(temp!=null)//check for left node
				{
					stack.push(temp);
					temp=temp.left;
				}
			}	
		}
		//find kth smallest element in list
		System.out.println(list);
		return list.get(k-1) ;
		
	}

}
